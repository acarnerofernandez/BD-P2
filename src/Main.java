import java.sql.Date;

public class Main {

    public static void main(String[] args) {
        CRUD crud = new CRUD();

        System.out.println("=== 1. CREAR (INSERTAR) ONE PIECE ===");
        Date fechaEstreno = Date.valueOf("1999-10-20");
        crud.meterAnime("One Piece", "Un chico de goma busca ser el Rey de los Piratas.", fechaEstreno, 90);

        System.out.println("\n=== 2. LEER TODOS LOS DATOS ===");
        crud.leerDatos();

        System.out.println("\n=== 3. MODIFICAR ONE PIECE ===");
        Date nuevaFecha = Date.valueOf("1999-10-20");
        crud.actualizarAnime(
                "One Piece",
                "Luffy y su tripulación luchan en el Nuevo Mundo.",
                nuevaFecha,
                96
        );

        System.out.println("\n=== LEER DATOS TRAS MODIFICAR ===");
        crud.leerDatos();

        System.out.println("\n=== 4. ELIMINAR ONE PIECE ===");
        crud.eliminarAnime("One Piece");

        System.out.println("\n=== LEER DATOS TRAS ELIMINAR ===");
        crud.leerDatos();
    }
}