package utils;

public class PrettyPrint {
    /** Scrolling text animation
     *
     * @param text        text to display in the command line
     * @param typingSpeed gap in ms between characters
     * @param delay       pause in ms after tuping text */
    public static void ScrollTextPrint(String text, long typingSpeed, long delay) {
        try {
            for (int i= 0; i < text.length(); i++ ) {
                System.out.print(text.charAt(i));
//                System.out.flush();
                Thread.sleep(typingSpeed);
            }
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /** Scrolling text animation with newline at end
     *
     * @param text        text to display in the command line
     * @param typingSpeed gap in ms between characters
     * @param delay       pause in ms after tuping text */
    public static void ScrollTextPrintln(String text, long typingSpeed, long delay) {
        ScrollTextPrint(text + "\n", typingSpeed, delay);
    }
}
