/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package engtelecom.poo;

public class App {
    public static void main(String[] args) {
        Data d = new Data(28, 2, 2020);
        System.out.println(d);
        System.out.println(d.dataExtenso());
        Data e = new Data(28, 2, 2022);
        System.out.println(d.dataDiferenca(e));
    }
}
