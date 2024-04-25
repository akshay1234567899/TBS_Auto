package PageFactory;


import Pages.*;


public class ObjectFactory {

    private LoginPage loginPage;
    private CreateAccount createaccount;
    private AddItemOnCart additemcart;

    private Checkoutpage check_outpage;
    private PaymentPage orderpayment;

    private ThankYouPage thankyoupage;

    private GuestUser guestuser;
    private LoggedinUserOrder getloggedinuser;
    private DeliveryOrderGuestUser getdeliveryorderguestuser;

    private DeliveryOrderByLoggedInUser getloggedindeliveryorder;


    public LoginPage getLoginPage() {

        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public CreateAccount getCreateAccount() {
        if (createaccount == null) {
            createaccount = new CreateAccount();
        }
        return createaccount;
    }

    public AddItemOnCart getAdditemcart() {
        if (additemcart == null) {
            additemcart = new AddItemOnCart();
        }
        return additemcart;
    }

    public Checkoutpage getcheckoutpage() {
        if (check_outpage == null) {
            check_outpage = new Checkoutpage();
        }
        return check_outpage;
    }

    public PaymentPage getorderpayment() {
        if (orderpayment == null) {
            orderpayment = new PaymentPage();
        }
        return orderpayment;
    }

    public ThankYouPage getthankyoupage(){
        if(thankyoupage==null){
            thankyoupage= new ThankYouPage();
        }
        return thankyoupage;
    }

    public GuestUser getguestuser(){
        if (guestuser==null){
            guestuser=new GuestUser();
        }
        return  guestuser;
    }

    public LoggedinUserOrder getloggedinuserorder(){
        if(getloggedinuser==null){
            getloggedinuser= new LoggedinUserOrder();
        }
        return  getloggedinuser;
    }

    public DeliveryOrderGuestUser getdeliveryorderguestuser(){
        if(getdeliveryorderguestuser==null){
            getdeliveryorderguestuser= new DeliveryOrderGuestUser();
        }
        return  getdeliveryorderguestuser;
    }
    public DeliveryOrderByLoggedInUser getloggedindeliveryorder(){
        if (getloggedindeliveryorder==null){
            getloggedindeliveryorder=new DeliveryOrderByLoggedInUser();
        }
        return getloggedindeliveryorder;
    }
}