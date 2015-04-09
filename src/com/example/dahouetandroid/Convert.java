﻿package com.example.dahouetandroid;

import java.util.*;

/**
 * Classe de conversion de devises
 * 
 * @author FAYOLLE Marc
 */
public class Convert
{
	//private static Map conversionTable = new HashMap();
	private static Map<String, Double> conversionTable = new HashMap<String, Double>();
	
	// static fonctionne comme un constructeur dans une classe static
	static                                                                                                     
   	{                                                                                                                                               
   		conversionTable.put("Livre", Double.valueOf(0.6404));                                           
   		conversionTable.put("Euro", Double.valueOf(0.7697));                                          
   		conversionTable.put("Dirham", Double.valueOf(8.5656));                                      
   		conversionTable.put("Yen", Double.valueOf(76.6908));                                              
   		conversionTable.put("Francs CFA", Double.valueOf(503.17));                                         
   		conversionTable.put("Dollars US", Double.valueOf(1.0));                                                    
   	}  
	
	/**
	 * Retourne un Double correspondant au <b>montant</b> en devise <b>source</b> converti en devise <b>cible</b></b>
	 * @param source
	 * @param cible
	 * @param montant
	 * @return le montant en devise cible
	 */
   	public static double convertir(String source, String cible, double montant)                                                                                          
   	{                                                                                                          
   		double tauxSource = conversionTable.get(source);                    
   		double tauxCible = conversionTable.get(cible);                    
   		double tauxConversion = tauxCible/tauxSource;	                                                       
   		return (montant * tauxConversion) ;                                                               
   	}           
   	
   	/**
   	 * Accesseur du tableau associatif des devises
   	 * @return une référence sur la table des devises
   	 */
   	public static Map<String, Double> getConversionTable()
   	{
   		return conversionTable;	
   	}                                                                                               
}                                                                                                         