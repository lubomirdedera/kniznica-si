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
 * <p>Rozhranie reprezentujúce riadiacu vrstvu kninièného systému voèi pouívate¾skému rozhraniu.</p>
 * <!-- end-UML-doc -->
 * @author dedera
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ManazerKnizniceFacade {
	/** 
	* <!-- begin-UML-doc -->
	* <p>Zadaného èitate¾a zaeviduje v systéme, priradí mu evidenèné èíslo, ktoré vráti.</p>
	* <!-- end-UML-doc -->
	* @param citatel
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	int vytvorCitatela(Citatel citatel) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vráti èitate¾a so zadanım evidenènım èíslom. Ak takı neexistuje, vráti null.</p>
	* <!-- end-UML-doc -->
	* @param ecc
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	Citatel najdiCitatela(int ecc) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vráti zoznam èitate¾ov so zadanım priezviskom.</p>
	* <!-- end-UML-doc -->
	* @param priezvisko
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	List<Citatel> najdiCitatela(String priezvisko) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Aktualizuje v systéme èitate¾a  pod¾a atribútov v citatel.</p>
	* <!-- end-UML-doc -->
	* @param citatel
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void aktualizujCitatela(Citatel citatel) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Zruší evidenciu zadaného èitate¾a v systéme, ak nemá evidované iadne vıpoièky.</p>
	* <!-- end-UML-doc -->
	* @param citatel
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void zrusCitatela(Citatel citatel) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Zadanú publikáciu zaeviduje v systéme, priradí jej evidenèné èíslo, ktoré vráti.</p>
	* <!-- end-UML-doc -->
	* @param publikacia
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	int zaevidujPublikaciu(Publikacia publikacia) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vráti publikáciu so zadanım evidenènım èíslom publikácie. Ak taká neexistuje, vráti null.</p>
	* <!-- end-UML-doc -->
	* @param ecp
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	Publikacia najdiPublikaciu(int ecp) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vytvorí zoznam publikácii, kde nájde medzi autormi a názvami dané textové reazce.</p>
	* <!-- end-UML-doc -->
	* @param autor
	* @param nazov
	* @return <p>Vráti zoznam publikácii korešpondujúci so zadanım autorom alebo názvom.</p>
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	List<Publikacia> najdiPublikaciu(String autor, String nazov) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Zadanú publikáciu vyradí z evidencie v systéme.</p>
	* <!-- end-UML-doc -->
	* @param publikacia <p></p>
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void vyradPublikaciu(Publikacia publikacia) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vytvorí pre zadaného èitate¾a vıpoièku zadanej publikácie so zadanou vıpoiènou lehotou v dòoch. </p>
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
	* @param publikacia <p>Zruší vıpoièku zadanej publikácie v systéme.</p>
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void vratPublikaciu(Publikacia publikacia) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vráti zoznam všetkıch vıpoièiek zadaného èitate¾a.</p>
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
	* @return <p>Vráti vıpoièku zadanej publikácie.</p>
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	Vypozicka najdiVypozickuPublikacie(Publikacia publikacia) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Predåi vıpoièku zadanej publikácie o zadanı poèet dní.</p>
	* <!-- end-UML-doc -->
	* @param publikacia
	* @param pocetDni
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void predlzVypozicku(Publikacia publikacia, int pocetDni) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Predåi zadanú vıpoièku o zadanı poèet dní.</p>
	* <!-- end-UML-doc -->
	* @param vypozicka
	* @param pocetDni
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void predlzVypozicku(Vypozicka vypozicka, int pocetDni) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Aktualizuje vıpoièku v systéme pod¾a parametra vypozicka.</p>
	* <!-- end-UML-doc -->
	* @param vypozicka
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void aktualizujVypozicku(Vypozicka vypozicka) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>U zadaného èitate¾a zosynchronizuje jeho vıpoièky pod¾a evidencie v systéme.</p>
	* <!-- end-UML-doc -->
	* @param citatel
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void zosynchronizujVypozickyCitatela(Citatel citatel) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>U zadanej publikácie zosynchronizuje jej vıpoièku pod¾a evidencie v systéme.</p>
	* <!-- end-UML-doc -->
	* @param publikacia <p></p>
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	void zosynchronizujVypozickuPublikacie(Publikacia publikacia) throws Exception;

	/** 
	* <!-- begin-UML-doc -->
	* <p>Vráti zoznam všetkıch vıpoièiek v systéme.</p>
	* <!-- end-UML-doc -->
	* @return
	* @throws Exception
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	List<Vypozicka> najdiVsetkyVypozicky() throws Exception;
}