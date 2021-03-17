package com.ts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dao.ProductDao;
import com.model.Product;

@RestController
public class ProductController {

	@Autowired
	ProductDao productdao;

	@RequestMapping("/registerProducts")
	public void register() {
		Product p1 = new Product();

		p1.setProductName("iphoneXR");
		p1.setPrice(56878.89);

		productdao.register(p1);
	}

	@RequestMapping("/showAllProducts")
	public List<Product> showAllProducts() {
		List<Product> productList = productdao.getProduct();
		return productList; // browser or any client
	}

	@PostMapping("/uploadImage")
	public void uploadImage(@RequestPart("Image") MultipartFile file, @RequestParam("productName") String productName,
			@RequestParam("price") double price, @RequestParam("availability") String availability) throws IOException {
		System.out.println("Upload called...");

		Path root = Paths.get("src/main/resources/uploads");
		// Files.createDirectory(root);
		// System.out.println(root+" : "+file.getOriginalFilename());

		Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));

		Product product = new Product();
		product.setProductName(productName);
		product.setPrice(price);
		product.setAvailability(availability);
		product.setImagePath(file.getOriginalFilename());
		productdao.register(product);

	}

	@RequestMapping(value = "/showImage/{imageName}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public void getImage(HttpServletResponse response, @PathVariable("imageName") String imageName) throws IOException {

		ClassPathResource imgFile = new ClassPathResource("uploads/" + imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}

	/*
	 * @PostMapping(value="/purchase") public void purchase(@RequestBody
	 * PurchaseOrder orders) throws Exception { System.out.println("Recieved " +
	 * orders);
	 * 
	 * Orders order = new Orders(); order.setAmount(orders.getAmount());
	 * order.setAddress(orders.getAddress()); order.setOrderDate(new Date());
	 * Customer customer = new Customer();
	 * customer.setCustId(orders.getCustomer().getCustId());
	 * order.setCustomer(customer); ordersDao.register(order);//first register order
	 * object to get id List<OrderDetails> ordDetails = new
	 * ArrayList<OrderDetails>(); for(Items item : orders.getOrderDetails()){
	 * Product product = new Product(); product.setProductId(item.getProductId());
	 * OrderDetails orderDetails = new OrderDetails();
	 * orderDetails.setProduct(product); orderDetails.setOrder(order);
	 * orderDetails.setQuantity(1); orderDetailsDao.register(orderDetails); } }
	 */

	/*
	 * @PostMapping(value="/purchase") public void purchase(@RequestPart("items")
	 * String items,@RequestPart("userId") String userId) throws Exception {
	 * System.out.println("Recieved " + items+" User Id :"+userId); ObjectMapper obj
	 * = new ObjectMapper(); JSONParser json = new JSONParser(); JSONArray
	 * arr=(JSONArray)json.parse(items);
	 * 
	 * Orders order = new Orders(); order.setAmount(1000);
	 * order.setAddress("10-20,east"); order.setOrderDate(new Date()); Customer
	 * customer = new Customer(); customer.setCustId(Integer.parseInt(userId));
	 * order.setCustomer(customer);
	 * 
	 * ordersDao.register(order);
	 * 
	 * List<OrderDetails> ordDetails = new ArrayList<OrderDetails>();
	 * 
	 * for(int i=0; i<arr.size(); i++){ JSONObject jsonData=(JSONObject)arr.get(i);
	 * Items cartItem = obj.readValue(jsonData.toString(),Items.class);
	 * System.out.println(cartItem.getProductId()+" "+cartItem.getProductName());
	 * OrderDetails orderDetails = new OrderDetails(); Product product = new
	 * Product(); product.setProductId(cartItem.getProductId());
	 * orderDetails.setProduct(product); orderDetails.setOrder(order);
	 * orderDetails.setQuantity(1); orderDetailsDao.register(orderDetails); } }
	 */
}
