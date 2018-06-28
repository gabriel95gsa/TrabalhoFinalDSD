package assets;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class MenuBebida {
    
    private List<Bebida> bebidas;

    public MenuBebida() {
        bebidas = new ArrayList<>();
        bebidas.add(new Bebida("Skol"));
        bebidas.add(new Bebida("Heineken"));
        bebidas.add(new Bebida("Stella Artois"));
        bebidas.add(new Bebida("Devassa"));
        bebidas.add(new Bebida("Budweiser"));
        bebidas.add(new Bebida("Jameson Irish Whiskey"));
        bebidas.add(new Bebida("The Famous Grouse Whisky"));
        bebidas.add(new Bebida("Black Label - Johnnie Walker"));
        bebidas.add(new Bebida("Green Label - Johnnie Walker"));
        bebidas.add(new Bebida("Gold Label - Johnnie Walker"));
        bebidas.add(new Bebida("Blue Label - Johnnie Walker"));
        bebidas.add(new Bebida("Smirnoff Ice"));
        bebidas.add(new Bebida("Smirnoff Red"));
        bebidas.add(new Bebida("Smirnoff Black"));
        bebidas.add(new Bebida("Bacardi"));
        bebidas.add(new Bebida("Absolut"));
        bebidas.add(new Bebida("Grey Goose"));
        bebidas.add(new Bebida("Belvedere"));
        bebidas.add(new Bebida("Finlandia"));
        bebidas.add(new Bebida("Red Bull"));
        bebidas.add(new Bebida("TNT"));
        bebidas.add(new Bebida("Guaraná Antarctica"));
        bebidas.add(new Bebida("Coca Cola"));
        bebidas.add(new Bebida("Pepsi"));
        bebidas.add(new Bebida("Schweppes"));
    }

    /**
     * Getters e Setters
     */
    
    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }
    
    public void addIngrediente(Bebida ingrediente) {
        this.bebidas.add(ingrediente);
    }
    
    public int getNroBebidasMenu() {
        return this.bebidas.size();
    }
    
}
