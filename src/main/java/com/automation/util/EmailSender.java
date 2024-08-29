package com.automation.util;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;

public class EmailSender {
    private static final String host = "mail.optimiza.me";
    private static final String username = "test-automation@optimizasolutions.com";
    private static final String password = "M@RT1299";
    private static final String from = "test-automation@optimizasolutions.com";
    private static final String reportDirectory = "D:\\Automation Quality Projects\\Dewan-Automation\\reports";
    private static final String cc = "mbarghuthi@optimizasolutions.com";
    private static final String[] to = { "mbarghuthi@optimizasolutions.com", "sjaber@optimizasolutions.com" };

    public void sendSuccessEmail() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "25");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        File latestFile = getLatestReportFile();

        if (latestFile == null) {
            System.out.println("No .htm files found in the directory.");
            return;
        }

        try {
            Message message = prepareMessage(session, latestFile);
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private File getLatestReportFile() {
        File directory = new File(reportDirectory);

        // Get all subdirectories
        File[] subdirs = directory.listFiles(File::isDirectory);

        if (subdirs == null || subdirs.length == 0) {
            System.out.println("No subdirectories found in the specified directory.");
            return null;
        }

        // Sort subdirectories by last modified date in descending order
        Arrays.sort(subdirs, Comparator.comparingLong(File::lastModified).reversed());

        // Get the latest subdirectory
        File latestDir = subdirs[0];

        // Get the HTML file from the latest subdirectory
        File[] htmlFiles = latestDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".htm") || name.toLowerCase().endsWith(".html");
            }
        });

        if (htmlFiles == null || htmlFiles.length == 0) {
            System.out.println("No HTML files found in the latest subdirectory.");
            return null;
        }

        // Return the first HTML file found (assuming there's only one)
        return htmlFiles[0];
    }

    private Message prepareMessage(Session session, File latestFile) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));

        for (String recipient : to) {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        }

        message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
        message.setSubject("Extent Report");

        Multipart multipart = new MimeMultipart();

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Hello,\nPlease find the latest test report in the attachment.\nRegards,\nImageLinks Automation Team");
        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(latestFile.getAbsolutePath());
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(latestFile.getName());
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        return message;
    }
}
