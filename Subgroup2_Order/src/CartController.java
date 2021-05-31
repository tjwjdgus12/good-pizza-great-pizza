package good_pizza_great_pizza;

public class CartController {
	public CartManager.Cart getCartInfo() {
		return CartManager.getCartList();
	}
	
	public boolean setCart(int menu_index, int count, char oper) {
		return true;
	}
}
