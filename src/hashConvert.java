import java.util.Scanner;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.PrintWriter;

public class hashConvert {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException
    {
        
        boolean on = true;
        boolean truth = true;
        int max = 50;
        int min = 100;
        double random_int = Math.floor(Math.random() * (max - min + 1) + min);
        String txtFileName = "output" + String.format("%.0f", random_int) + ".txt";
        PrintWriter txtFile = new PrintWriter(txtFileName);

        System.out.println(entryMessage());
        
        while (on)
        {
        Scanner cin = new Scanner(System.in);
        System.out.print(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " + "Type a " 
                    + ANSI_CYAN + "word " + ANSI_RESET + "to be converted to a hash : " + ANSI_GREEN);
            String wordConvert = cin.nextLine();
            
            while (truth)
            {
                for (int i = 0; i < wordConvert.length(); i++)
                {
                    char c = wordConvert.charAt(i);
                    if (Character.isDigit(c))
                    {
                        System.out.print(ANSI_RED + "[" + ANSI_RESET + "♥" + ANSI_RED + "] " 
                                    + "CAN NOT CONTAIN INTEGERS. TRY AGAIN : " + ANSI_GREEN);
                        wordConvert = cin.nextLine();
                        i = 0;
                    }
                    else if (c == ' ')
                    {
                        System.out.print(ANSI_RED + "[" + ANSI_RESET + "♥" + ANSI_RED + "] " 
                                    + "CAN NOT CONTAIN SPACES. TRY AGAIN : " + ANSI_GREEN);
                        wordConvert = cin.nextLine();
                        if (wordConvert.matches("[^A-Za-z0-9]"))
                        {
                            System.out.print(ANSI_RED + "[" + ANSI_RESET + "♥" + ANSI_RED + "] " 
                                    + "CAN NOT CONTAIN NON-ENGLISH CHARACTERS. TRY AGAIN : " + ANSI_GREEN);
                            wordConvert = cin.nextLine();
                        }
                        i = 0;
                    }
                    else if (wordConvert.length() == 1 && wordConvert.matches("[a-zA-Z+]"))
                    {
                        truth = false;
                    }
                    else if (!wordConvert.matches("[a-zA-Z][a-zA-Z\\s]+$"))
                    {
                        System.out.print(ANSI_RED + "[" + ANSI_RESET + "♥" + ANSI_RED + "] " 
                                    + "CAN NOT CONTAIN NON-ENGLISH CHARACTERS. TRY AGAIN : " + ANSI_GREEN);
                        wordConvert = cin.nextLine();
                        i = 0;
                    }
                    else
                    {
                        truth = false;
                    }
                }
            }
            truth = true;

        System.out.println(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " + "What hashtype would you like to convert " 
                        + ANSI_GREEN + "\"" + wordConvert + "\"" + ANSI_RESET + " to?" + ANSI_GREEN);
        System.out.print(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " + "(MD5 = 0; SHA-1 = 100; SHA-256 (case sensitive) = 1400), " 
                        + ANSI_RED + "NEGATIVE NUMBER" + ANSI_RESET + " TO END PROCESS : " + ANSI_GREEN);
        
            int hashType = cin.nextInt();
            String convertedHash;

            if (hashType < 0)
            {
                System.out.print(exitMessage());
                on = false;
            }
            else if (hashType == 0) // MD5
            {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(StandardCharsets.UTF_8.encode(wordConvert));
                convertedHash = String.format("%032x", new BigInteger(1, md5.digest()));
                System.out.println(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " + "Your generated hash : " 
                            + ANSI_GREEN + convertedHash + " (MD5)" + ANSI_RESET);
                txtFile.print(convertedHash + " (MD5)");
                txtFile.println();
                System.out.print(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " + "Would you like to continue? " 
                            + ANSI_CYAN + "(Y for Yes, anything else for No) " + ANSI_RESET + " : " + ANSI_GREEN);
                char yesOrNo = cin.next().charAt(0);
            
                if (!(yesOrNo == 'Y' || yesOrNo == 'y'))
                {
                    System.out.print(exitMessage());
                    on = false;
                    txtFile.close();
                }

            }
            else if (hashType == 100) // SHA-1
            {
                MessageDigest sha1 = MessageDigest.getInstance("SHA1");
                sha1.update(StandardCharsets.UTF_8.encode(wordConvert));
                convertedHash = String.format("%032x", new BigInteger(1, sha1.digest()));
                System.out.println(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " 
                            + "Your generated hash : " + ANSI_GREEN + convertedHash + " (SHA-1)" + ANSI_RESET);
                txtFile.print(convertedHash + " (SHA-1)");
                txtFile.println();
                System.out.print(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " 
                            + "Would you like to continue? " + ANSI_CYAN + "(Y for Yes, anything else for No) " + ANSI_RESET + " : " + ANSI_GREEN);
                char yesOrNo = cin.next().charAt(0);
            
                if (!(yesOrNo == 'Y' || yesOrNo == 'y'))
                {
                    System.out.print(exitMessage());
                    on = false;
                    txtFile.close();
                }
            }
            else if (hashType == 1400) // SHA-256
            {
                MessageDigest sha256 = MessageDigest.getInstance("SHA256");
                sha256.update(StandardCharsets.UTF_8.encode(wordConvert));
                convertedHash = String.format("%032x", new BigInteger(1, sha256.digest()));
                System.out.println(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " 
                            + "Your generated hash : " + ANSI_GREEN + convertedHash + " (SHA-256)" + ANSI_RESET);
                txtFile.print(convertedHash + " (SHA-256)");
                txtFile.println();
                System.out.print(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " 
                            + "Would you like to continue? " + ANSI_CYAN + "(Y for Yes, anything else for No) " + ANSI_RESET + " : " + ANSI_GREEN);
                char yesOrNo = cin.next().charAt(0);
            
                if (!(yesOrNo == 'Y' || yesOrNo == 'y'))
                {
                    System.out.print(exitMessage());
                    on = false;
                    txtFile.close();
                }
            }
            else
            {
                boolean endCheck = true;
                
                while (endCheck == true)
                {
                    System.out.print(ANSI_RED + "[" + ANSI_RESET + "♥" + ANSI_RED + "] " + "Incorrect hash type. Try again : " + ANSI_GREEN);
                    hashType = cin.nextInt();

                if (hashType == 0) // MD5
                {
                    MessageDigest md5 = MessageDigest.getInstance("MD5");
                    md5.update(StandardCharsets.UTF_8.encode(wordConvert));
                    convertedHash = String.format("%032x", new BigInteger(1, md5.digest()));
                    System.out.println(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " 
                                + "Your generated hash : " + ANSI_GREEN + convertedHash + " (MD5)" + ANSI_RESET);
                    txtFile.print(convertedHash + " (MD5)");
                    txtFile.println();
                    System.out.print(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " 
                                + "Would you like to continue? " + ANSI_CYAN + "(Y for Yes, anything else for No) " + ANSI_RESET + " : " + ANSI_GREEN);
                    char yesOrNo = cin.next().charAt(0);
                
                    if (!(yesOrNo == 'Y' || yesOrNo == 'y'))
                    {
                        System.out.print(exitMessage());
                        on = false;
                        txtFile.close();
                    }
                    endCheck = false;
                }
                else if (hashType == 100) // SHA-1
                {
                    MessageDigest sha1 = MessageDigest.getInstance("SHA1");
                    sha1.update(StandardCharsets.UTF_8.encode(wordConvert));
                    convertedHash = String.format("%032x", new BigInteger(1, sha1.digest()));
                    System.out.println(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " + "Your generated hash : " 
                                + ANSI_GREEN + convertedHash + " (SHA-1)" + ANSI_RESET);
                    txtFile.print(convertedHash + " (SHA-1)");
                    txtFile.println();
                    System.out.print(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " + "Would you like to continue? " 
                                + ANSI_CYAN + "(Y for Yes, anything else for No) " + ANSI_RESET + " : " + ANSI_GREEN);
                    char yesOrNo = cin.next().charAt(0);
                
                    if (!(yesOrNo == 'Y' || yesOrNo == 'y'))
                    {
                        System.out.print(exitMessage());
                        on = false;
                        txtFile.close();
                    }
                    endCheck = false;
                }
                else if (hashType == 1400) // SHA-256
                {
                    MessageDigest sha256 = MessageDigest.getInstance("SHA256");
                    sha256.update(StandardCharsets.UTF_8.encode(wordConvert));
                    convertedHash = String.format("%032x", new BigInteger(1, sha256.digest()));
                    System.out.println(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " + "Your generated hash : " 
                                + ANSI_GREEN + convertedHash + " (SHA-256)" + ANSI_RESET);
                    txtFile.print(convertedHash + " (SHA-256)");
                    txtFile.println();
                    System.out.print(ANSI_RESET + "[" + ANSI_RED + "♥" + ANSI_RESET + "] " + "Would you like to continue? " 
                                + ANSI_CYAN + "(Y for Yes, anything else for No) " + ANSI_RESET + " : " + ANSI_GREEN);
                    char yesOrNo = cin.next().charAt(0);
                
                    if (!(yesOrNo == 'Y' || yesOrNo == 'y'))
                    {
                        System.out.print(exitMessage());
                        on = false;
                        txtFile.close();
                    }
                    endCheck = false;
                }
            }
            }
        }
    }
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_CYAN = "\u001B[36m";

        public static String exitMessage()
        {
            String wholeExit = ANSI_GREEN + System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
                            + "             ▄████  ▒█████   ▒█████  ▓█████▄  ▄▄▄▄ ▓██   ██▓▓█████  ▐██▌ " + System.lineSeparator()
                            + "            ██▒ ▀█▒▒██▒  ██▒▒██▒  ██▒▒██▀ ██▌▓█████▄▒██  ██▒▓█   ▀  ▐██▌ " + System.lineSeparator()
                            + "           ▒██░▄▄▄░▒██░  ██▒▒██░  ██▒░██   █▌▒██▒ ▄██▒██ ██░▒███    ▐██▌ " + System.lineSeparator()
                            + "           ░▓█  ██▓▒██   ██░▒██   ██░░▓█▄   ▌▒██░█▀  ░ ▐██▓░▒▓█  ▄  ▓██▒ " + System.lineSeparator()
                            + "           ░▒▓███▀▒░ ████▓▒░░ ████▓▒░░▒████▓ ░▓█  ▀█▓░ ██▒▓░░▒████▒ ▒▄▄  " + System.lineSeparator()
                            + "            ░▒   ▒ ░ ▒░▒░▒░ ░ ▒░▒░▒░  ▒▒▓  ▒ ░▒▓███▀▒ ██▒▒▒ ░░ ▒░ ░ ░▀▀▒ " + System.lineSeparator()
                            + "             ░   ░   ░ ▒ ▒░   ░ ▒ ▒░  ░ ▒  ▒ ▒░▒   ░▓██ ░▒░  ░ ░  ░ ░  ░ " + System.lineSeparator()
                            + "           ░ ░   ░ ░ ░ ░ ▒  ░ ░ ░ ▒   ░ ░  ░  ░    ░▒ ▒ ░░     ░       ░ " + System.lineSeparator()
                            + "                 ░     ░ ░      ░ ░     ░     ░     ░ ░        ░  ░ ░    " + System.lineSeparator()
                            + "                                      ░            ░░ ░                  " + System.lineSeparator()
                            + System.lineSeparator() + System.lineSeparator() + ANSI_RESET;
            return wholeExit;
        }

        public static String entryMessage()
        {
            String wholeEntry = ANSI_GREEN + System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
            + " ██░ ██  ▄▄▄        ██████  ██░ ██     ▄████▄   ▒█████   ███▄    █ ██▒   █▓▓█████  ██▀███  ▄▄▄█████▓▓█████  ██▀███  " + System.lineSeparator()
            + "▓██░ ██▒▒████▄    ▒██    ▒ ▓██░ ██▒   ▒██▀ ▀█  ▒██▒  ██▒ ██ ▀█   █▓██░   █▒▓█   ▀ ▓██ ▒ ██▒▓  ██▒ ▓▒▓█   ▀ ▓██ ▒ ██▒" + System.lineSeparator()
            + "▒██▀▀██░▒██  ▀█▄  ░ ▓██▄   ▒██▀▀██░   ▒▓█    ▄ ▒██░  ██▒▓██  ▀█ ██▒▓██  █▒░▒███   ▓██ ░▄█ ▒▒ ▓██░ ▒░▒███   ▓██ ░▄█ ▒" + System.lineSeparator()
            + "░▓█ ░██ ░██▄▄▄▄██   ▒   ██▒░▓█ ░██    ▒▓▓▄ ▄██▒▒██   ██░▓██▒  ▐▌██▒ ▒██ █░░▒▓█  ▄ ▒██▀▀█▄  ░ ▓██▓ ░ ▒▓█  ▄ ▒██▀▀█▄  " + System.lineSeparator()
            + "░▓█▒░██▓ ▓█   ▓██▒▒██████▒▒░▓█▒░██▓   ▒ ▓███▀ ░░ ████▓▒░▒██░   ▓██░  ▒▀█░  ░▒████▒░██▓ ▒██▒  ▒██▒ ░ ░▒████▒░██▓ ▒██▒" + System.lineSeparator()
            + " ▒ ░░▒░▒ ▒▒   ▓▒█░▒ ▒▓▒ ▒ ░ ▒ ░░▒░▒   ░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ▒ ▒   ░ ▐░  ░░ ▒░ ░░ ▒▓ ░▒▓░  ▒ ░░   ░░ ▒░ ░░ ▒▓ ░▒▓░" + System.lineSeparator()
            + " ▒ ░▒░ ░  ▒   ▒▒ ░░ ░▒  ░ ░ ▒ ░▒░ ░     ░  ▒     ░ ▒ ▒░ ░ ░░   ░ ▒░  ░ ░░   ░ ░  ░  ░▒ ░ ▒░    ░     ░ ░  ░  ░▒ ░ ▒░" + System.lineSeparator()
            + " ░  ░░ ░  ░   ▒   ░  ░  ░   ░  ░░ ░   ░        ░ ░ ░ ▒     ░   ░ ░     ░░     ░     ░░   ░   ░         ░     ░░   ░ " + System.lineSeparator()
            + " ░  ░  ░      ░  ░      ░   ░  ░  ░   ░ ░          ░ ░           ░      ░     ░  ░   ░                 ░  ░   ░     " + System.lineSeparator()
            + "                                      ░                                ░                                            " + System.lineSeparator()
            + System.lineSeparator() + System.lineSeparator() + ANSI_RESET;

            return wholeEntry;
        }
}
