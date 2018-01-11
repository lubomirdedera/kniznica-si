package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kniznica.controller.ManazerKnizniceFacade;
import kniznica.entities.Citatel;
import kniznica.entities.Publikacia;


/**
 * Servlet implementation class Test
 */
@WebServlet("/")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(beanName="ManazerKniznice")
	ManazerKnizniceFacade mk;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Citatel c1 = new Citatel();
		c1.setMeno("Jano");
		c1.setPriezvisko("Kri�ka"); 
		c1.setRc(6703016023L);
		
		Citatel c2 = new Citatel();
		c2.setMeno("Fero");
		c2.setPriezvisko("Kri�ka");
		c2.setRc(6903016023L);
		
		Citatel c3 = new Citatel();
		c3.setMeno("Julo");
		c3.setPriezvisko("Trnka");
		c3.setRc(7003016023L);
		
		Publikacia p1 = new Publikacia();
		p1.setAutor("�ubom�r Dedera");
		p1.setNazov("Po��ta�ov� jazyky a ich spracovanie");
		
		Publikacia p2 = new Publikacia();
		p2.setAutor("Martin Kuku��n");
		p2.setNazov("Dom v str�ni");
		
		Publikacia p3 = new Publikacia();
		p3.setAutor("CCC");
		p3.setNazov("Kniha CCC");
		
		
		try {
			response.setCharacterEncoding("UTF-16");
			PrintWriter out = response.getWriter();
			mk.vytvorCitatela(c1); 
			mk.vytvorCitatela(c2);
			mk.vytvorCitatela(c3);
			out.println("<p>Vytvorenie 3 �itate�ov prebehlo �spe�ne. </p>"); 
			out.println("<p>Test na pridelenie ecc- o�ak�va sa 2: "+ c2.getEcc()+"</p>"); 
			
			out.println("<p>Test na vyh�adanie �itate�ov  pod�a priezviska- o�ak�va sa 2: "+ mk.najdiCitatela("Kri�ka").size()+"</p>"); 
			
			c1.setMeno("Ivan");
			mk.aktualizujCitatela(c1);
			
			Citatel c4=mk.najdiCitatela(1);
			out.println("<p>Test na akualizaciu a najdenie existujuceho citatela - o�ak�va sa Ivan: "+ c4.getMeno()+"</p>"); 
			
			Citatel c5 = mk.najdiCitatela(10);
			if (c5 == null) {
				out.println("<p>Test na vyh�adanie neexistuj�ceho �itate�a prebehol �spe�ne. </p>"); 
			}
			else {
				out.println("<p>Test na vyh�adanie neexistuj�ceho �itate�a neprebehol �spe�ne. </p>"); 
			}
			
			mk.zaevidujPublikaciu(p1);
			mk.zaevidujPublikaciu(p2);
			mk.zaevidujPublikaciu(p3);
			out.println("<p>Zaevidovanie 3 publikacii prebehlo �spe�ne. </p>"); 
			
			mk.vypozicajPublikaciu(c1, p2, 30);
			mk.vypozicajPublikaciu(c1, p3, 30);
			mk.vypozicajPublikaciu(c1, p1, 30); 
			
			
			mk.zosynchronizujVypozickyCitatela(c1);
			out.println("<p> Test na vypo�i�anie publik�ci� - o�ak�van� hodnota 3: "+c1.getVypozicky().size()+"</p>"); 
			
			List<Publikacia> lp = mk.najdiPublikaciu("Dedera", "");
			
			out.println("<p> Test na n�jdenie publik�ci� pod�a autora - o�ak�van� hodnota 1: "+lp.size()+"</p>"); 

			Publikacia p4 = mk.najdiPublikaciu(3);
			out.println("<p> Test na  vypo�i�an� - o�ak�va sa 1: "+p4.getJeVypozicane()+"</p>");
			
			mk.vratPublikaciu(p3);
			mk.zosynchronizujVypozickuPublikacie(p3);
			out.println("<p>Test na vr�tenie publik�cie  - o�ak�va sa 0: "+p3.getJeVypozicane()+"</p>");
			mk.zosynchronizujVypozickyCitatela(c1);
			out.println("<p>Test na synchroniz�ciu v�po�i�iek  - o�ak�va sa 2: "+ c1.getVypozicky().size()+"</p>");
			
			for (int i = 0; i < c1.getVypozicky().size(); i++) {
				out.println("<p>"+c1.getVypozicky().get(i).getPublikacia().getAutor()+"</p>");
			}
			
			out.println("<p>Test sa zru�enie �itate�a s v�po�i�kami - nemal by prejs�: </p>"); 
			try {
				mk.zrusCitatela(c1);
			} catch(Exception e){
				out.println(e.getMessage()+"\n");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
