package SC01;
public class Main {

    public static void main(String[] args) {

        BST bst = new BST();
        int[] books = {
                50, 30, 70, 20, 40, 60, 80
        };


        for(int book : books) {
            bst.insert(book);
        }


        System.out.println("Laporan daftar buku terurut:");
        bst.inorder();

        System.out.println();

        System.out.println(
                "jumlah buku: "
                        + bst.countNodes()
        );
    }
}