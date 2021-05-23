package good_pizza_great_pizza;
import java.util.ArrayList;


public class CartManager extends Menu {
	private static Cart cart;
	
	public static Cart getCartList() {
		return cart;
	}
	
	public boolean setCartList(int menu_index, int count, char oper) {
		return true;
	}
	
	public void resetCart() {
		
	}
	
	public class Cart{
		public ArrayList<Menu> menus = new ArrayList<>();
		public ArrayList<Integer> num = new ArrayList<>();
	}
}
