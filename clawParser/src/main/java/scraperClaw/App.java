package scraperClaw;

public class App 
{
    public static void main( String[] args )
    {
    	String addr = "http://www.nasdaq.com/screening/industries.aspx";
    	String industry = "Finance";
    	Parser.title(addr);
        Parser.summon("http://www.nasdaq.com/screening/companies-by-industry.aspx?industry=" + industry);
    }
}
