/**
 * 
 */
package kniznica.controller;

import kniznica.entities.Citatel;
import java.util.List;
import kniznica.entities.Publikacia;
import kniznica.entities.Vypozicka;

/** 
 * <!-- begin-UML-doc -->
 * <p>Rozhranie reprezentuj�ce riadiacu vrstvu kni�ni�n�ho syst�mu vo�i pou��vate�sk�mu rozhraniu.</p>
 * <!-- end-UML-doc -->
 * @author dedera
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ManazerKnizniceFacade {
	/** 
	* <!-- begin-UML-doc -->
	* <p>Zadan�ho �itate�a zaeviduje v syst�me, prirad� mu eviden�n� ��slo, ktor� vr�ti.</p>
	* <!-- end-UML-doc -->
	* @param citatel
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	int vytvorCitatela(Citatel citatel) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vr�ti �itate�a so zadan�m eviden�n�m ��slom. Ak tak� neexistuje, vr�ti null.</p>
	* <!-- end-UML-doc -->
	* @param ecc
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	Citatel najdiCitatela(int ecc) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vr�ti zoznam �itate�ov so zadan�m priezviskom.</p>
	* <!-- end-UML-doc -->
	* @param priezvisko
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	List<Citatel> najdiCitatela(String priezvisko) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Aktualizuje v syst�me �itate�a  pod�a atrib�tov v citatel.</p>
	* <!-- end-UML-doc -->
	* @param citatel
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void aktualizujCitatela(Citatel citatel) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Zru�� evidenciu zadan�ho �itate�a v syst�me, ak nem� evidovan� �iadne v�po�i�ky.</p>
	* <!-- end-UML-doc -->
	* @param citatel
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void zrusCitatela(Citatel citatel) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Zadan� publik�ciu zaeviduje v syst�me, prirad� jej eviden�n� ��slo, ktor� vr�ti.</p>
	* <!-- end-UML-doc -->
	* @param publikacia
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	int zaevidujPublikaciu(Publikacia publikacia) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vr�ti publik�ciu so zadan�m eviden�n�m ��slom publik�cie. Ak tak� neexistuje, vr�ti null.</p>
	* <!-- end-UML-doc -->
	* @param ecp
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	Publikacia najdiPublikaciu(int ecp) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vytvor� zoznam publik�cii, kde n�jde medzi autormi a n�zvami dan� textov� re�azce.</p>
	* <!-- end-UML-doc -->
	* @param autor
	* @param nazov
	* @return <p>Vr�ti zoznam publik�cii kore�ponduj�ci so zadan�m autorom alebo n�zvom.</p>
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	List<Publikacia> najdiPublikaciu(String autor, String nazov) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Zadan� publik�ciu vyrad� z evidencie v syst�me.</p>
	* <!-- end-UML-doc -->
	* @param publikacia <p></p>
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void vyradPublikaciu(Publikacia publikacia) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vytvor� pre zadan�ho �itate�a v�po�i�ku zadanej publik�cie so zadanou v�po�i�nou lehotou v d�och. </p>
	* <!-- end-UML-doc -->
	* @param citatel
	* @param publikacia
	* @param vypozicnaLehota
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void vypozicajPublikaciu(Citatel citatel, Publikacia publikacia, int vypozicnaLehota) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param publikacia <p>Zru�� v�po�i�ku zadanej publik�cie v syst�me.</p>
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void vratPublikaciu(Publikacia publikacia) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vr�ti zoznam v�etk�ch v�po�i�iek zadan�ho �itate�a.</p>
	* <!-- end-UML-doc -->
	* @param citatel
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	List<Vypozicka> najdiVypozickyCitatela(Citatel citatel) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param publikacia
	* @return <p>Vr�ti v�po�i�ku zadanej publik�cie.</p>
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	Vypozicka najdiVypozickuPublikacie(Publikacia publikacia) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Pred�i v�po�i�ku zadanej publik�cie o zadan� po�et dn�.</p>
	* <!-- end-UML-doc -->
	* @param publikacia
	* @param pocetDni
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void predlzVypozicku(Publikacia publikacia, int pocetDni) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Pred�i zadan� v�po�i�ku o zadan� po�et dn�.</p>
	* <!-- end-UML-doc -->
	* @param vypozicka
	* @param pocetDni
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void predlzVypozicku(Vypozicka vypozicka, int pocetDni) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Aktualizuje v�po�i�ku v syst�me pod�a parametra vypozicka.</p>
	* <!-- end-UML-doc -->
	* @param vypozicka
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void aktualizujVypozicku(Vypozicka vypozicka) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>U zadan�ho �itate�a zosynchronizuje jeho v�po�i�ky pod�a evidencie v syst�me.</p>
	* <!-- end-UML-doc -->
	* @param citatel
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void zosynchronizujVypozickyCitatela(Citatel citatel) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>U zadanej publik�cie zosynchronizuje jej v�po�i�ku pod�a evidencie v syst�me.</p>
	* <!-- end-UML-doc -->
	* @param publikacia <p></p>
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void zosynchronizujVypozickuPublikacie(Publikacia publikacia) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vr�ti zoznam v�etk�ch v�po�i�iek v syst�me.</p>
	* <!-- end-UML-doc -->
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	List<Vypozicka> najdiVsetkyVypozicky() throws Exception;
}