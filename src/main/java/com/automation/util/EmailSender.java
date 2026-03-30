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

    private static final String to = "sjaber@optimizasolutions.com";
    private static final String cc = "mbarghuthi@optimizasolutions.com";

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
            System.out.println("No HTML report file found in the latest report directory.");
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
        File directory = new File(resolveReportDirectory());

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Report directory does not exist: " + directory.getAbsolutePath());
            return null;
        }

        File[] subdirs = directory.listFiles(File::isDirectory);

        if (subdirs == null || subdirs.length == 0) {
            System.out.println("No subdirectories found in the specified directory.");
            return null;
        }

        Arrays.sort(subdirs, Comparator.comparingLong(File::lastModified).reversed());
        File latestDir = subdirs[0];

        File[] htmlFiles = latestDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String lower = name.toLowerCase();
                return lower.endsWith(".htm") || lower.endsWith(".html");
            }
        });

        if (htmlFiles == null || htmlFiles.length == 0) {
            System.out.println("No HTML files found in the latest subdirectory.");
            return null;
        }

        Arrays.sort(htmlFiles, Comparator.comparingLong(File::lastModified).reversed());
        return htmlFiles[0];
    }

    private String resolveReportDirectory() {
        String reportDirectoryProperty = System.getProperty("reportDirectory");
        if (isNotBlank(reportDirectoryProperty)) {
            return reportDirectoryProperty;
        }

        String workspace = System.getenv("WORKSPACE");
        if (isNotBlank(workspace)) {
            return workspace + File.separator + "reports";
        }

        return System.getProperty("user.dir") + File.separator + "reports";
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

    private Message prepareMessage(Session session, File latestFile) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
        message.setSubject("Recent Dewan Automation Test Report");

        Multipart multipart = new MimeMultipart();

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(
                "Dear,\n" +
                        "I hope this message finds you well. Please find attached the most recent automation test report for Dewan.\n\n" +
                        "Feel free to review it and share any feedback or observations.\n\n" +
                        "Best regards,\n" +
                        "ImageLinks Automation Team"
        );
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