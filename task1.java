public class task1 {
    public static void main(String[] args) {
        print_answer("Основание 53.742, степень 4, результат равен");
        print_answer("Основание 3, степень 5.4, результат равен");
        print_answer("степень 2, Основание 4, результат равен");
        print_answer("Основание 5, степень 0, результат равен");
        print_answer("результат равен, ОсновАНие 5, стЕпеНь 2, ");
        print_answer("Основание -15, степень -2, результат равен");


    }
    static void print_answer(String question) {
        String[] arr = split_condition(question);
        arr = count_answer(arr, find_ground(arr), find_degree(arr));
        System.out.println(answer(arr));
    }
    static String[] split_condition(String condition) {
        String[] split_string = condition.split(", ");
        return split_string;
    }
    static double find_ground(String[] string_array) {
        double ground = 0;
        for (int i = 0; i < string_array.length; i++) {
            if (string_array[i].toLowerCase().contains("основание")) {
                String[] str = string_array[i].split(" ");
                ground = try_transform(str[str.length - 1]);
            }
        }
        return ground;
    }    

            
    static double find_degree(String[] string_array) {
        double degree = 0;
        for (int i = 0; i < string_array.length; i++) {
            if (string_array[i].toLowerCase().contains("степень")) {
                String[] str = string_array[i].split(" ");
                degree = try_transform(str[str.length - 1]);
                
            }
        }
        return degree;
    }
            
            
        

    static String[] count_answer(String [] string_array, double gr, double deg) {
        for (int i = 0; i < string_array.length; i++) {
            if (string_array[i].toLowerCase().contains("результат равен")) {
                double scale = Math.pow(10, 3);
                string_array[i] = string_array[i] + " " + Double.toString(Math.round(Math.pow(gr, deg)*scale)/scale);
            }
        }
        return string_array;
    }

    static String answer(String[] string_array) {
        return String.join(", ", string_array);
    }

        
    static double try_transform(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException  e) {
            return 0;
        }
    }
}


