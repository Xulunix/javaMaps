package de.javamaps;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.Stack;

import javax.xml.stream.XMLStreamException;

import de.javamaps.items.Vertex;

public class javaMap {
	static Gui window;

	public static void main(String[] args) {
		window = new Gui();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		try {
			XmlReader.XmlReader(window);
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DistanceCalc.distanceCalculation(XmlReader.vertexMap);
		long start = 104580839; //Stuttgart Flughafen/Messe
		long end = 24557201; //Berlin-Spandau
		/*
		 * for(Vertex v : XmlReader.vertexMap){
		 * System.out.println(v.getNeighbors()); }
		 */
		System.out.println("Route wird berechnet...");
		System.out.println("Dieser Vorgang kann einige Minuten in Anspruch nehmen");
		window.addLocations(MotorwayRamp.getMotorwayRamps(XmlReader.vertexMap)); //Auswahlpunkte hinzufügen
		
		
		
		//StringBuffer output = Dijkstra.getshortestWay(start, end, XmlReader.vertexMap);
		//System.out.println(output);
		//Stack<Vertex> routeStack = (Dijkstra.getfullWayStack(XmlReader.vertexMap, end));
		//window.drawRoute(routeStack);
	}
	
	public static void calcRoute(long start, long end){
		StringBuffer output = Dijkstra.getshortestWay(start, end, XmlReader.vertexMap);
		System.out.println(output);
		Stack<Vertex> routeStack = (Dijkstra.getfullWayStack(XmlReader.vertexMap, end));
		window.drawRoute(routeStack);
	}

}
