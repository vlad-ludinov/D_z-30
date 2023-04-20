public class task2 {
    public static void main(String[] args) {

        String text = "На дворе трава, на траве дрова, не руби дрова, на траве двора";
        StringBuilder textBuilder = new StringBuilder(text);
        System.out.println(count_time_String(text, "дрова", "кларнет"));
        System.out.println(count_time_StringBuilder(textBuilder, "дрова", "корабли"));
    }

    static String replace_String_word(String text, String replaceable_word, String replacement_word) {
        String[] split_text = text.split(replaceable_word);
        String final_text = split_text[0];
        for (int i = 1; i < split_text.length; i++) {
            final_text = final_text + replacement_word + split_text[i];
        }
        return final_text;

    }

    static StringBuilder replace_StringBuilder_word(StringBuilder text, String replaceable_word,
            String replacement_word) {
        while (text.indexOf(replaceable_word) >= 0) {
            text.insert(text.indexOf(replaceable_word), replacement_word);
            text.delete(text.indexOf(replaceable_word), text.indexOf(replaceable_word) + replaceable_word.length());
        }
        return text;
    }

    static long count_time_String(String text, String replaceable_word, String replacement_word) {
        long start_nano = System.nanoTime();
        System.out.println(replace_String_word(text, replaceable_word, replacement_word));
        long end_nano = System.nanoTime();
        long time_String = end_nano - start_nano;
        return time_String;
    }

    static long count_time_StringBuilder(StringBuilder text, String replaceable_word, String replacement_word) {
        long start_nano = System.nanoTime();
        System.out.println(replace_StringBuilder_word(text, replaceable_word, replacement_word));
        long end_nano = System.nanoTime();
        long time_StringBuilder = end_nano - start_nano;
        return time_StringBuilder;
    }
}
