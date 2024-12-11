package leetcode.unique_emails;

import java.util.ArrayList;
import java.util.List;

public class UniqueEmails {
    public int numUniqueEmails(String[] emails) {
        List<String> validEmails = new ArrayList<>();
        for (int i = 0; i < emails.length; i++) {
            String[] emailParts = emails[i].split("@");
            String currentEmail = emailParts[0].replaceAll("\\+.*", "").replaceAll("\\.", "") + "@"
                    + emailParts[1];
            if (!validEmails.contains(currentEmail))
                validEmails.add(currentEmail);
        }
        return validEmails.size();
    }
}