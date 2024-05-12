package ToDoListJava;

public class ApplikasiTodoList {
    public static String [] datas =new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        testInput();
    }

    public static void menampilkanTodoList(){
        for(var i=0;i<datas.length;i++){
            var data = datas[i];
            var no =i+1;

            if(data!=null){
                System.out.println(no+". "+data);
            }
        }
    }

    public static void testMenampilkanTodoList(){
        datas[0]="fikran belajar java";
        datas[1]="fikran belajar TodoList";
        menampilkanTodoList();
    }

    public static void menambahTodoList(String dataTodo){
        var isFull = true;
        for (int i = 0; i < datas.length; i++) {
            if (datas[i] == null) {
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        if(isFull){
            var temp = datas;
            datas = new String [datas.length*2];
            for (int i = 0; i < temp.length; i++) {
                datas[i] = temp[i];
            }
        }

        for(int i=0;i<datas.length;i++){
            if(datas[i]==null){
                datas[i]=dataTodo;
                break;
            }
        }

    }

    public static void testMenambahaTodoList(){
        menambahTodoList("fikran");
        menambahTodoList("belajar");
        menambahTodoList("Todo");
        menampilkanTodoList();
    }

    public static boolean menghapusTodoList(int indexNum){
        if((indexNum-1)>=datas.length){
            return false;
        }else if (datas[indexNum-1]==null){
            return false;
        }else {
            datas[indexNum-1]=null;

            for (int i = indexNum-1; i < datas.length; i++) {
                if(i== datas.length-1){
                    datas[i]=null;
                }else {
                    datas[i]=datas[i+1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        menambahTodoList("testFikran");
        menambahTodoList("testFikran");
        menambahTodoList("testFikran");
        boolean testResult = menghapusTodoList(2);
        System.out.println(testResult);
        menampilkanTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }



    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    public static void viewMenampilkanTodoList(){
        while (true) {
            menampilkanTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewMenambahTodoList();
            } else if (input.equals("2")) {
                viewMenghapusTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void viewMenambahTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")) {
            // batal
        } else {
            menambahTodoList(todo);
        }

    }

    public static void viewMenghapusTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang Dihapus (x Jika Batal)");

        if (number.equals("x")) {
            // batal
        } else {
            boolean success = menghapusTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }
}
