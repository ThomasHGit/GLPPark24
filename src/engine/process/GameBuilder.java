
package engine.process;

import config.ParcConfig;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Curseur;

public class GameBuilder {
	public static Map buildMap() {
		return new Map(ParcConfig.LINE_COUNT, ParcConfig.COLUMN_COUNT);
	}
	public static ParcManager buildInitMobile(Map map) {
		ParcManager manager = new ParcManager(map);
		intializeCurseur(map, manager);
		return manager;
	}

	private static void intializeCurseur(Map map, ParcManager manager) {
		Block block = map.getBlock(ParcConfig.LINE_COUNT - 1, (ParcConfig.COLUMN_COUNT - 1) / 2);
		Curseur Curseur = new Curseur(block);
		manager.set(Curseur);
	}
}