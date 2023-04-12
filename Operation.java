import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Operation {

	void Exchange () {
		Integer num = 0;
		System.out.println("1.상품코드 조회");
		System.out.println("2.안내");
		System.out.println("3.상품 교환");
		
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        if (num <= 0 || num >= 5){
            System.out.println("잘못 입력하셨습니다.\n메뉴에 맞는 번호를 입력해주세요.");
            Exchange();
        }
		
		switch(num) {
		case 1: searchCode();
			 	break;
		case 2 : information();
				break;
		case 3 : exchange();
				break;
		}
	}

	private void information() {
		System.out.println("안내하는 곳");		
	}

	private void exchange() {
		String reg = "^clalm\\[A-Za-z]{5}[0-9]{9}";
		boolean check;
		do {
			System.out.println("clalm + 가게번호 + 상품번호를 입력해주세요");
			Scanner scanner = new Scanner(System.in);
			String StoreAndProduct = scanner.nextLine().replaceAll("\\s", "");

			String StoreCode =StoreAndProduct.substring(5, 10);

			String ProductCode = StoreAndProduct.substring(10);

			check = Pattern.matches(reg, StoreAndProduct);
			List<String> Stores = new ArrayList<>();
			Store1 store1 = new Store1();
			Store2 store2 = new Store2();
			Stores.add(store1.Store1Code);
			Stores.add(store2.Store2Code);
			if(Stores.contains(StoreCode)) {
				if(StoreCode.equals(store1.Store1Code)) {
					List<String> Products = new ArrayList<>();
					Products.add(store1.product1);
					Products.add(store1.product2);
					Products.add(store1.product3);
					Products.add(store1.product4);
					Products.add(store1.product5);
					if(Products.contains(ProductCode)) {
						System.out.println("1번 가게에서 교환되엇습니다.");
					}else {
						System.out.println("제품 번호를 다시 입력해주세요");
					}
				}else {
					List<String> Products = new ArrayList<>();
					Products.add(store2.product6);
					Products.add(store2.product7);
					Products.add(store2.product8);
					Products.add(store2.product9);
					Products.add(store2.product10);
					if(Products.contains(ProductCode)) {
						System.out.println("2번 가게에서 교환되엇습니다.");
					}else {
						System.out.println("제품 번호를 다시 입력해주세요");
					}
				}
			}else {
				System.out.println("가게 번호가 틀립니다. 다시 입력해주세요");
				exchange();
			}
			
		}while(!check);
	}

	private void searchCode() {
		String reg = "^[0-9]*$";
		boolean check;
		do {
		System.out.println("Check + 상품 번호를 입력해주세요");
		Scanner scanner = new Scanner(System.in);
		String productCode = scanner.nextLine().replaceAll("\\s", "").substring(5);
		System.out.println(productCode);
		check = Pattern.matches(reg, productCode);
		if(check==true) {
			Products products = new Products();
			List<String> product = new ArrayList<>();
			product.add(products.productCode1);
			product.add(products.productCode2);
			product.add(products.productCode3);
			product.add(products.productCode4);
			product.add(products.productCode5);
			product.add(products.productCode6);
			product.add(products.productCode7);
			product.add(products.productCode8);
			product.add(products.productCode9);
			product.add(products.productCode10);
			if(product.contains(productCode)) {			
				System.out.println("교환 가능합니다.");
				Exchange();
			}else {
				System.out.println("해당 상품이 존재하지 않습니다.");
				searchCode();
			}
			
		}
		else {}
		}while(!check);
		
		
	}
	
}
