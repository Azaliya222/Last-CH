package all.laba6_2_s.etc;

public class Log {
        public static void create(String message){
            System.out.println("[CREATED]\t" + message);
        }
        public static void delete(String message){
            System.out.println("[DELETED]\t" + message);
        }
        public static void move(String message){
            System.out.println("[MOVED]\t\t" + message);
        }
        public static void change(String message){
            System.out.println("[CHANGED]\t" + message);
        }
        public static void erase(String message){
            System.out.println("[ERASED]\t" + message);
        }

}

