package gui;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.util.*;
import java.awt.event.*;

public class MainMenuFrame extends JFrame
{
	private JPanel contentPane;

	public JPanel pnCategory;
	public MenuPanel pnMenu;
	public BasketContainer pnBasket;
	public JPanel pnLogo;
	public JPanel pnBtn;
	public JLabel lbTotalMoney;
	public JLabel lbTitle;
	public JLabel lbLeft;
	public JLabel lbRight;
	public CategoryPanel pnType;

//	public Basket bk;
	private JPanel pnGroup1;
	private JPanel pnGroup2;
	private JPanel pnPayment;
	
	private JPanel panel;
	private JLabel lbDummy;

	MainMenuFrame frm;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		 new MainMenuFrame();
	
	}

	/**
	 * Create the frame.
	 */
	public MainMenuFrame()
	{
		frm = this;

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(20, 20, 630, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pnGroup1 = new JPanel();
		pnGroup1.setLayout(new BorderLayout(0, 0));

		pnCategory = new JPanel();
		pnCategory.setBackground(Color.ORANGE);
		pnCategory.setPreferredSize(new Dimension(630, 150));

		pnGroup1.add(pnCategory, BorderLayout.NORTH);
		pnCategory.setLayout(new BorderLayout(0, 0));

		pnLogo = new JPanel();
		pnLogo.setPreferredSize(new Dimension(630, 80));
		pnLogo.setBackground(Product.STARBUCKS_GREEN);
		pnCategory.add(pnLogo, BorderLayout.NORTH);

		ImageIcon icon = new ImageIcon("images/logo/로고(67x62).jpg");
		Image sca = icon.getImage().getScaledInstance(75, 75, Image.SCALE_FAST);
		icon.setImage(sca);
		pnLogo.setLayout(new BorderLayout(0, 0));

		lbTitle = new JLabel("메뉴 고르기");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		pnLogo.add(lbTitle);

		pnBtn = new JPanel();
		pnCategory.add(pnBtn, BorderLayout.CENTER);
		pnBtn.setLayout(new BorderLayout(0, 0));

		pnType = new CategoryPanel(this);

		pnBtn.add(pnType, BorderLayout.CENTER);


		pnMenu = new MenuPanel(this);
		pnMenu.setPreferredSize(new Dimension(630, 500));
		pnMenu.setBackground(Color.WHITE);
		pnGroup1.add(pnMenu, BorderLayout.CENTER);

		contentPane.add(pnGroup1, BorderLayout.NORTH);

		pnGroup2 = new JPanel();
		pnGroup2.setLayout(new BorderLayout(0, 0));

		pnBasket = new BasketContainer(this);
		pnBasket.setBackground(Color.WHITE);
		pnBasket.setPreferredSize(new Dimension(630, 250));
		pnGroup2.add(pnBasket, BorderLayout.NORTH);

		contentPane.add(pnGroup2, BorderLayout.CENTER);

		
		ImageIcon ic = new ImageIcon("images\\logo\\credit_card.png");

		Image scaled = ic.getImage().getScaledInstance(25, 25, Image.SCALE_FAST);
		ic.setImage(scaled);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		

		lbDummy = new JLabel("\uCD1D \uACB0\uC81C \uAE08\uC561");
		lbDummy.setOpaque(true);
		lbDummy.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lbDummy.setHorizontalAlignment(SwingConstants.CENTER);
		lbDummy.setForeground(Color.WHITE);
		lbDummy.setBackground(Product.STARBUCKS_GREEN);
		panel.add(lbDummy);

		lbTotalMoney = new JLabel("0");
		lbTotalMoney.setForeground(Color.WHITE);
		lbTotalMoney.setOpaque(true);
		lbTotalMoney.setBackground(Product.STARBUCKS_GREEN);
		lbTotalMoney.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lbTotalMoney.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbTotalMoney);
		setVisible(true);
	}
}

class Product {
	
	private int id; // 관리번호 <<PK>>
	private String name;// 이름  <<UQ>>
	private String category;// 카테고리  coffee/beverage/salad/dessert
	private String imagePath;// 사진파일경로
	private int price;// 가격
	private int hot; // hot/ice
	private Date regDay;// 출시일

	public static final String DEF_NAME = "NOT AVAILABLE";
	public static final int DEF_PRICE = 0;
	public static final String DEF_IMAGE = "sample.png";
	public static final int NO_TEMPERATURE_SELECT = 3;
	
	public static final String[] CATEGORY = {"Coffee", "Beverage", "Salad", "Dessert"};
	public static final Color STARBUCKS_GREEN = new Color(0, 122, 74);
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(String name, String category, String imagePath, int price, int hot) {
		this(0, name, category, imagePath, price, hot, new Date());
	}


	public Product(int id, String name, String category, String imagePath, int price, int hot, Date regDay) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.imagePath = imagePath;
		this.price = price;
		this.hot = hot;
		this.regDay = regDay;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getHot() {
		return hot;
	}


	public void setHot(int hot) {
		this.hot = hot;
	}


	public Date getRegDay() {
		return regDay;
	}
	
	public void setRegDay(Date regDay) {
		this.regDay = regDay;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", imagePath=" + imagePath
				+ ", price=" + price + ", hot=" + hot + ", regDay=" + regDay + "]";
	}
}
class order {
	private int id; // 관리번호 <pk>
	private String orderNumber; //  주문 번호  임의로 줘보자~
	private String memberLogin; // 주문자  <pk> -> <fk>
	private String productName; // 주문 상품 이름  <pk> -> <fk>
	private int quantity; // 수량
	private int totalPrice; // 총가격
	private Date orderedTime; // 주문 시간
	private int orderStatus;// 주문상태
	
	public static final int ORDER_REQUEST =1;
	public static final int ORDER_PREPARE =2;
	public static final int ORDER_FINISHED =3;
	@Override
	public String toString() {
		return "order [id=" + id + ", orderNumber=" + orderNumber + ", memberLogin=" + memberLogin + ", productName="
				+ productName + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", orderedTime=" + orderedTime
				+ ", orderStatus=" + orderStatus + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getMemberLogin() {
		return memberLogin;
	}
	public void setMemberLogin(String memberLogin) {
		this.memberLogin = memberLogin;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderedTime() {
		return orderedTime;
	}
	public void setOrderedTime(Date orderedTime) {
		this.orderedTime = orderedTime;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public order() {
		// TODO Auto-generated constructor stub
	}
	public order(int id, String orderNumber, String memberLogin, String productName, int quantity, int totalPrice,
			Date orderedTime, int orderStatus) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.memberLogin = memberLogin;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderedTime = orderedTime;
		this.orderStatus = orderStatus;
	}
}

class Admin {
	private int id; //°ü¸®¹øÈ£ <<PK>>
	private String login; //ÀÌ¸§  <<UQ>>
	private String pw;
	private String name;
	private Date regDay;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegDay() {
		return regDay;
	}
	public void setRegDay(Date regDay) {
		this.regDay = regDay;
	}
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String login, String pw, String name) {
		this(0, login, pw, name, null);
	}
	public Admin(int id, String login, String pw, String name, Date regDay) {
		super();
		this.id = id;
		this.login = login;
		this.pw = pw;
		this.name = name;
		this.regDay = regDay;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", pw=" + pw + ", name=" + name + ", regDay=" + regDay + "]";
	}
	
	
}

class BasketContainer extends JPanel
{
	public MainMenuFrame frm;
	public JPanel pnVP;
	public JScrollPane scrollPane;
	
	
	public static HashMap<Product, Integer> bkMap = new HashMap<>(); // 상품, 수량
	public static ArrayList<BasketPanel> bkList = new ArrayList<>(); 
	
	/**
	 * Create the panel.
	 */
	
	public BasketContainer(MainMenuFrame frm)
	{
		
		this.frm = frm;
		setSize(600, 250);
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		add(scrollPane, BorderLayout.CENTER);

		pnVP = new JPanel();
		pnVP.setOpaque(true);
		pnVP.setBackground(Color.white);
		pnVP.setMaximumSize(new Dimension(600, 32767));
		scrollPane.setViewportView(pnVP);
		FlowLayout fl_pnVP = new FlowLayout();
		fl_pnVP.setVgap(0);
		fl_pnVP.setHgap(0);
		pnVP.setLayout(fl_pnVP);
		
		
	}
	// 총가격 업데이트
	public static void updateTotalPrice(MainMenuFrame frm)
	{
		int tPrice = 0;
		
		Iterator<Product> products =  bkMap.keySet().iterator();
		
		while (products.hasNext())
		{
			Product pr = products.next();
			int p = pr.getPrice();
			int a = bkMap.get(pr);
			tPrice += p * a;

			for (BasketPanel bk : bkList)
			{
				if (bk.product.equals(pr))
				{
					bk.lbPrice.setText(pr.getPrice() * Integer.valueOf(bk.pnOC.txtVal.getText()) + "원");
				}
			}
		}
		frm.lbTotalMoney.setText(tPrice + "원");
	}
	
	// 해당 basketPanel 삭제후 다시 추가
	public static boolean removeOneProduct(MainMenuFrame frm, Product product)
	{
		
		Component[] pnList = frm.pnBasket.pnVP.getComponents();
		int vert = bkMap.size() - 1; 
		
		for (Component c : pnList)
		{
			BasketPanel pn = (BasketPanel) c;
			
			if (pn.product.equals(product))
			{
				frm.pnBasket.pnVP.remove(pn);
				bkMap.remove(product);
				bkList.remove(pn);
				frm.pnBasket.pnVP.setPreferredSize(new Dimension(600, 100 * vert));
				frm.pnBasket.pnVP.repaint();
				frm.pnBasket.pnVP.revalidate();
				return true;
			}
		}
		return false;
	}
	
	// 장바구니에 추가
	public boolean addProductToBasket(Product pr, int amount)
	{
		if (pr == null)
			return false;
		
		JPanel pn = frm.pnBasket.pnVP;
		Product key = pr;
		int value = amount;
		int vert = bkMap.size() + 1;  
		
		if (bkMap.containsKey(key))
		{
			for (BasketPanel pnBasket : bkList)
			{
				if (pnBasket.product.equals(pr))
					pnBasket.pnOC.txtVal.setText("" + value );
			}
			bkMap.replace(key, value);
			return true;
		}
		if (bkMap.containsKey(key) == false)
		{
			BasketPanel pnBk = new BasketPanel(frm, pr, amount);
			pn.add(pnBk);
			pn.setPreferredSize(new Dimension(600, 100 * vert));
			pn.revalidate();
			bkMap.put(key, value);
			bkList.add(pnBk);
			return true;
		}
		return false;
	}
}


class MenuPanel extends JPanel
{
   MainMenuFrame frm;
   public JPanel pnCard;
   public CardLayout card;
   
   /**
    * Create the panel.
    */
   public MenuPanel(MainMenuFrame frm)
   {
      setPreferredSize(new Dimension(600, 500));
      this.frm = frm;
      ProductDBMgr mgr = new ProductDBMgr();
      HashMap<Integer, ArrayList<Product>> prMap = mgr.getProductsByType(); 
      
      System.out.println(prMap);
         
      
      setOpaque(true);
      setBackground(Color.white);
      setLayout(new BorderLayout(0, 0));
      

      
      card = new CardLayout(0, 0);
      pnCard = new JPanel();
      pnCard.setLayout(card);
      add(pnCard);
      
      ArrayList<Product> prList = null;
      
      for (int i = 0; i < Product.CATEGORY.length; i++)
      {
         prList = prMap.get(i);
         
         JPanel temp = new JPanel();
         temp.setLayout(new BorderLayout());
         
         
         JScrollPane scrollPane = new JScrollPane();
         scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
         scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
         scrollPane.getVerticalScrollBar().setUnitIncrement(15);
         temp.add(scrollPane, BorderLayout.CENTER);
         
         
         JPanel pn = new JPanel();
         pn.setLayout(new GridLayout(0, 3));
         
         pn.setOpaque(true);
         pn.setBackground(Color.white);
         
         for (int j = 0; j < prList.size(); j++)
         {
            Product pr = prList.get(j);
            ProductPanel pp = new ProductPanel(pr);
            pp.setPreferredSize(new Dimension(200, 250));
            pp.addMouseListener(new MouseAdapter()
            {
               @Override
               public void mouseClicked(MouseEvent e)
               {
                  BasketDialog bd = new BasketDialog(frm, pr);
                  bd.setVisible(true);
               }
            });
            pn.add(pp);
            scrollPane.setViewportView(pn);
         }
         pnCard.add(Product.CATEGORY[i], temp);
         prList.clear();
      }  
   }
}

class CategoryPanel extends JPanel
{	
	public final ButtonGroup btnGroup = new ButtonGroup();
	public JButton btn;
	
	MainMenuFrame frm;
	
	/**
	 * Create the panel.
	 */
	public CategoryPanel(MainMenuFrame frm)
	{
		this.frm = frm;
		setSize(630, 70);
		setLayout(new GridLayout(0, 4, 0, 0));
		Border emptyBorder = BorderFactory.createEmptyBorder();
		
		InvertColor ic = new InvertColor();
		changeCard cc = new changeCard();
		
		for (int i = 0; i < Product.CATEGORY.length; i++)
		{
			btn = new JButton(Product.CATEGORY[i]);
			btn.setBorder(emptyBorder);
			btn.setOpaque(true);
			btn.setForeground(Color.white);
			btn.setBackground(Product.STARBUCKS_GREEN);
			btn.setPreferredSize(new Dimension(630/4, 70));
			btn.setText(Product.CATEGORY[i]);
			btn.setHorizontalAlignment(SwingConstants.CENTER);
			btn.addFocusListener(ic);
			btn.addMouseListener(cc);
			btnGroup.add(btn);
			this.add(btn);
		}
	}
	
	
	public class InvertColor extends FocusAdapter
	{
		public InvertColor() {}

		@Override
		public void focusGained(FocusEvent e)
		{
			JButton btn = (JButton) e.getSource();
			btn.setForeground(Product.STARBUCKS_GREEN);
			btn.setBackground(Color.white);
		}

		@Override
		public void focusLost(FocusEvent e)
		{
			JButton btn = (JButton) e.getSource();
			btn.setForeground(Color.white);
			btn.setBackground(Product.STARBUCKS_GREEN);
		}
		
	}
	
	public class changeCard extends MouseAdapter
	{
		
		public changeCard() {}

		@Override
		public void mouseClicked(MouseEvent e)
		{
			CardLayout card = frm.pnMenu.card;
			JPanel pnCard = frm.pnMenu.pnCard;
			JButton btn = (JButton) e.getSource();
			String category = btn.getText();
			
			card.show(pnCard, category);
		}
	}
}

class BasketPanel extends JPanel
{
	public MainMenuFrame frm;
	public Product product;
	public OrderCount pnOC;

	public JLabel lbPrice;
	JLabel lbCancle;
	BasketPanel bkPn;

	/**
	 * Create the panel.
	 */
	public BasketPanel(MainMenuFrame frm, Product pr, int amount)
	{
		bkPn = this;
		this.frm = frm;
		
		BevelBorder b4 = new BevelBorder(BevelBorder.RAISED);
		setBorder(b4);
		
		this.product = pr;
		setSize(600, 80);
		setLayout(new BorderLayout(0, 0));
		
		setOpaque(true);
		setBackground(Color.white);
		

		JLabel lbPrName = new JLabel();
		lbPrName.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrName.setPreferredSize(new Dimension(200, 80));
		lbPrName.setText(product.getName());
		add(lbPrName, BorderLayout.WEST);

		pnOC = new OrderCount(frm, pr);
		pnOC.setBackground(Color.WHITE);
		pnOC.txtVal.setText("" + amount);

		pnOC.setMaximumSize(new Dimension(200, 80));
		pnOC.setPreferredSize(new Dimension(200, 80));
		add(pnOC, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(true);
		panel_1.setBackground(Color.white);
		panel_1.setPreferredSize(new Dimension(200, 80));
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));

		lbPrice = new JLabel();
		lbPrice.setBackground(Color.WHITE);
		lbPrice.setText("" + pr.getPrice() * amount + "¿ø");

		lbPrice.setMaximumSize(new Dimension(120, 80));
		lbPrice.setMinimumSize(new Dimension(120, 80));
		lbPrice.setSize(new Dimension(120, 80));
		lbPrice.setSize(100, 80);
		lbPrice.setFont(new Font("HY°­M", Font.BOLD, 16));
		lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbPrice, BorderLayout.CENTER);

		lbCancle = new JLabel("x\r\n");
		lbCancle.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				boolean b = BasketContainer.removeOneProduct(frm, pr);
				if (b == false)
					System.out.println("»èÁ¦ ½ÇÆÐ");
				BasketContainer.updateTotalPrice(frm);
			}
		});
		lbCancle.setSize(new Dimension(80, 80));
		lbCancle.setPreferredSize(new Dimension(80, 80));
		lbCancle.setFont(new Font("±¼¸²", Font.BOLD, 50));
		lbCancle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbCancle, BorderLayout.EAST);
	}

}

class OrderCount extends JPanel
{
	public JTextField txtVal;
	public JLabel lbPlus;
	public JLabel lbMinus;
	
	Product pr;
	
	OrderCount oc;

	/**
	 * Create the panel.
	 */
	public OrderCount(MainMenuFrame frm, Product pr)
	{
		this.pr = pr;
		oc = this;
		setSize(new Dimension(300, 80));
		setLayout(new GridLayout(0, 3, 0, 0));
		
		int p = pr.getPrice();
		
		lbMinus = new JLabel("-");
		lbMinus.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (Integer.valueOf(txtVal.getText()) > 1)
				{
					txtVal.setText(""+ (Integer.valueOf(txtVal.getText()) - 1));
					int a = Integer.valueOf(txtVal.getText());
					int nPrice = p * a;
					
					ArrayList<BasketPanel> bkList = BasketContainer.bkList;
					for (BasketPanel bk : bkList)
					{
						if (bk.product.equals(pr))
						{
							bk.lbPrice.setText(""+nPrice+ "¿ø");
							BasketContainer.bkMap.replace(bk.product, a);
							break;
						}
					}
					BasketContainer.updateTotalPrice(frm);
				}
			}
		});
		lbMinus.setHorizontalAlignment(SwingConstants.CENTER);
		lbMinus.setFont(new Font("±¼¸²", Font.PLAIN, 50));
		add(lbMinus);

		txtVal = new JTextField();
		txtVal.setOpaque(true);
		txtVal.setBackground(Color.white);
			
		txtVal.setText("" + 1);
		txtVal.setHorizontalAlignment(SwingConstants.CENTER);
		txtVal.setFont(new Font("Arial", Font.PLAIN, 35));
		txtVal.setEditable(false);
		txtVal.setColumns(10);
		add(txtVal); 
		lbPlus = new JLabel("+");
		lbPlus.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				txtVal.setText(""+ (Integer.valueOf(txtVal.getText()) + 1));
				int a = Integer.valueOf(txtVal.getText());
				int nPrice = p * a;
				
				ArrayList<BasketPanel> bkList = BasketContainer.bkList;
				for (BasketPanel bk : bkList)
				{
					if (bk.product.equals(pr))
					{
						bk.lbPrice.setText(""+nPrice+ "¿ø");
						BasketContainer.bkMap.replace(bk.product, a);
						break;
					}
				}
				BasketContainer.updateTotalPrice(frm);
			}
		});
		lbPlus.setHorizontalAlignment(SwingConstants.CENTER);
		lbPlus.setFont(new Font("±¼¸²", Font.PLAIN, 50));
		add(lbPlus);
	}
}

class BasketDialog extends JDialog
{

	MainMenuFrame frm;
	BasketDialog dlg;
	ProductPanel pp;
	JLabel lbTemperature;
	JPanel panel;
	JLabel lbPrName;
	JButton btnNewButton;
	public 	Product pr;
	public OrderCount pnAmount;
	
		/**
	 * Create the dialog.
	 */
	public BasketDialog(MainMenuFrame frm, Product pr)
	{
		super(frm, true);
		this.frm = frm;
		this.pr = pr;
		dlg = this;
		
		
		setTitle("수량 정하기");
		getContentPane().setPreferredSize(new Dimension(140, 400));
		
		setBounds(100, 100, 400, 180);
		getContentPane().setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 50));
		panel.setOpaque(true);
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		lbPrName = new JLabel();
		lbPrName.setPreferredSize(new Dimension(350, 50));
		lbPrName.setOpaque(true);
		lbPrName.setText(pr.getName());
		lbPrName.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrName.setBackground(Color.WHITE);
		panel.add(lbPrName, BorderLayout.CENTER);
		
		btnNewButton = new JButton("ok");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Product temp_pr = pr;
				Integer amount = Integer.valueOf(pnAmount.txtVal.getText());
				
				
				boolean b = frm.pnBasket.addProductToBasket(temp_pr, amount);
				if (b == false)
					System.out.println("BasketDialog ok 추가 실패");
				else
					System.out.println("BasketDialog ok 추가 성공");
				
				BasketContainer.updateTotalPrice(frm);
				frm.pnBasket.repaint();
				frm.pnBasket.revalidate();
				dlg.dispose();
			}
		});
		panel.add(btnNewButton, BorderLayout.EAST);
		
		// 다른 클래스꺼 받을때 JPanel로 받는게 아니라 OrderCount로 받던가 캐스팅 해야함
		pnAmount = new OrderCount(frm, pr);
		
		
		
		getContentPane().add(pnAmount, BorderLayout.CENTER);
		
		lbTemperature = new JLabel("");
		
		if (pr.getHot() == 1)
			lbTemperature.setText("HOT");
		if (pr.getHot() == 2)
			lbTemperature.setText("ICE");
		lbTemperature.setFont(new Font("Arial", Font.BOLD, 30));
		lbTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		lbTemperature.setOpaque(true);
		lbTemperature.setBackground(Color.WHITE);
		lbTemperature.setPreferredSize(new Dimension(100, 80));
		getContentPane().add(lbTemperature, BorderLayout.WEST);
	}
}
class ProductPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Product pr;
	JLabel lbImage;
	JLabel lbName;
	JLabel lbPrice;
	public int prPanelPrice;
	
	
	/**
	 * Create the panel.
	 */
	public ProductPanel(Product pr)
	{
		
		this.pr = pr;
		Dimension d1 = new Dimension(200, 250);
		
		setBorder(new EmptyBorder(10,10,10,10));

		setPreferredSize(d1);
		
		setLayout(new BorderLayout(0, 0));
		setOpaque(true);
		setBackground(Color.white);
		
		Dimension d2 = new Dimension(200, 50);
		
		
		lbImage = new JLabel("");
		lbImage.setSize(new Dimension(200, 150));
		lbImage.setOpaque(true);
		ImageIcon ic = new ImageIcon("images/menu/" + pr.getImagePath());
		Image scaled = ic.getImage().getScaledInstance(200, 150, Image.SCALE_FAST);
		
		ic.setImage(scaled);
		lbImage.setIcon(ic);
		lbImage.repaint();
		lbImage.setPreferredSize(new Dimension(200, 150));
		
		add(lbImage, BorderLayout.NORTH);
		
		lbName = new JLabel("");
		lbName.setPreferredSize(new Dimension(200, 50));
		lbName.setBackground(Color.LIGHT_GRAY);
		lbName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbName.setOpaque(true);
		lbName.setHorizontalAlignment(SwingConstants.CENTER);
		lbName.setSize(d2);
		lbName.setText(pr.getName());
		add(lbName, BorderLayout.CENTER);
		
		lbPrice = new JLabel("");
		lbPrice.setBackground(Color.LIGHT_GRAY);
		lbPrice.setOpaque(true);
		lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrice.setPreferredSize(d2);
		lbPrice.setText(""+pr.getPrice());
		this.prPanelPrice = pr.getPrice();
		add(lbPrice, BorderLayout.SOUTH);	
	}

}

class ProductDBMgr {
	
	ProductDBMgr(){
	}
	public HashMap<Integer,ArrayList<Product>> getProductsByType(){
		HashMap<Integer, ArrayList<Product>> prMap = new HashMap<>();
		ArrayList<Product> tempList1 = new ArrayList<>();
		ArrayList<Product> tempList2 = new ArrayList<>();
		ArrayList<Product> tempList3 = new ArrayList<>();
		ArrayList<Product> tempList4 = new ArrayList<>();
		
		Date regDay = new Date();
		
		tempList1.add(new Product(1,"아이스아메리카노","Coffee","아이스아메리카노.jpg",3000,1,regDay));
		tempList1.add(new Product(2,"아이스카라멜파키아또","Coffee","아이스카라멜마키아또.jpg",3000,1,regDay));
		tempList1.add(new Product(3,"아이스아메리카노","Coffee","아이스아메리카노.jpg",3000,1,regDay));
		tempList1.add(new Product(4,"아이스아메리카노","Coffee","아이스아메리카노.jpg",3000,1,regDay));
		
		prMap.put(0,tempList1);
		
		tempList2.add(new Product(1,"딸기주스","Beverage","딸기주스.jpg",3000,1,regDay));
		tempList2.add(new Product(2,"수박주스","Beverage","수박주스.jpg",3000,1,regDay));
		tempList2.add(new Product(3,"아이스아메리카노","Beverage","아이스아메리카노.jpg",3000,1,regDay));
		tempList2.add(new Product(4,"아이스아메리카노","Beverage","아이스아메리카노.jpg",3000,1,regDay));
		prMap.put(1,tempList2);
		
		tempList3.add(new Product(1,"아이스아메리카노","Salad","아이스아메리카노.jpg",3000,0,regDay));
		tempList3.add(new Product(2,"아이스카라멜파키아또","Salad","아이스카라멜파키아또.jpg",3000,0,regDay));
		tempList3.add(new Product(3,"아이스아메리카노","Salad","아이스아메리카노.jpg",3000,1,regDay));
		tempList3.add(new Product(4,"아이스아메리카노","Salad","아이스아메리카노.jpg",3000,1,regDay));
		prMap.put(2,tempList3);
		
		tempList4.add(new Product(1,"아이스아메리카노","Dessert","아이스아메리카노.jpg",3000,1,regDay));
		tempList4.add(new Product(2,"아이스카라멜파키아또","Dessert","아이스카라멜파키아또.jpg",3000,1,regDay));
		tempList4.add(new Product(3,"아이스아메리카노","Dessert","아이스아메리카노.jpg",3000,1,regDay));
		tempList4.add(new Product(4,"아이스아메리카노","Dessert","아이스아메리카노.jpg",3000,1,regDay));
		prMap.put(3,tempList4);
		
		return prMap;
	}
}