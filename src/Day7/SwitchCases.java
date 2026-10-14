void main() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the Day : ");
    String day = sc.next();

    String a = switch (day){
        case "Monday","Tuesday","Wednesday","Thursday","Friday" -> "WeekDays";
        default -> "WeekEnd";
    };

    System.out.println(a);
}