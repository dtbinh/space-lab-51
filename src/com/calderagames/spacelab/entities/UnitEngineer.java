package com.calderagames.spacelab.entities;

import com.calderagames.spacelab.animation.Animation;
import com.calderagames.spacelab.entities.capacities.ForceFieldBarrier;
import com.calderagames.spacelab.entities.capacities.SimpleGunShot;
import com.calderagames.spacelab.entities.items.ItemFactory;
import com.calderagames.spacelab.gamecontent.GameContent;
import com.calderagames.spacelab.gamemap.Map;
import com.calderagames.spacelab.graphics.Sprite;
import com.calderagames.spacelab.graphics.Texture;
import com.calderagames.spacelab.graphics.TextureRegion;

public class UnitEngineer extends PlayableEntity {

	public UnitEngineer(GameContent gc, Map map, BattleManager bm, int row, int col) {
		super(gc, map, bm, row, col);
		
		sprite = new Sprite(42, 58, new TextureRegion(gc.getRM().getTexture("texatlas"), 513, 193, 21, 31));
		sprPortrait = new Sprite(72, 60, new TextureRegion(gc.getRM().getTexture("texatlas"), 167, 514, 36, 30));
		sprMiniPortrait = new Sprite(34, 32, new TextureRegion(gc.getRM().getTexture("texatlas"), 515, 195, 17, 16));
		sprDead = new Sprite(64, 64, new TextureRegion(gc.getRM().getTexture("texatlas"), 579, 386, 32, 32));
		
		moveCost = 1;
		actionPoints = 5;
		maxActionPoints = 5;
		maxDamage = 100;
		damageAmount = 0;
		xpAmount = 50;
		
		setAttribute(Attributes.ROBUSTNESS, 7);
		setAttribute(Attributes.STAMINA, 5);
		setAttribute(Attributes.PRECISION, 2);
		setAttribute(Attributes.VELOCITY, 5);
		setAttribute(Attributes.TACTICAL, 5);
		
		inv.getItems().add(ItemFactory.createItem(gc, map, 0));
		inv.getItems().add(ItemFactory.createItem(gc, map, 1));
		inv.getItems().add(ItemFactory.createItem(gc, map, 4));
		inv.getItems().add(ItemFactory.createItem(gc, map, 5));
		
		capacities.add(new SimpleGunShot(gc, this, 10, 480));
		capacities.add(new ForceFieldBarrier(gc, this));
		selectedCapa = capacities.get(0);
		
		Texture texture = gc.getRM().getTexture("texatlas");
		
		animSet.setAnimation(0, new Animation(42, 58, new TextureRegion[8], 100, false));
		animSet.setSoundEffect(0, new int[] {0, 4}, "footstep-1", false, 1f, 0.1f, 0, 0);
		for(int i = 0; i < animSet.getAnimation(0).getFrames().length; i++) {
			animSet.getAnimation(0).getFrames()[i] = new TextureRegion(texture, 513 + 22 * i, 193, 21, 31);
		}
		
		animSet.setAnimation(1, new Animation(42, 58, new TextureRegion[8], 100, false));
		animSet.setSoundEffect(1, new int[] {0, 4}, "footstep-1", false, 1f, 0.1f, 0, 0);
		for(int i = 0; i < animSet.getAnimation(1).getFrames().length; i++) {
			animSet.getAnimation(1).getFrames()[i] = new TextureRegion(texture, 513 + 22 * i, 225, 21, 31);
		}
		
		animSet.setAnimation(2, new Animation(42, 58, new TextureRegion[8], 100, false));
		animSet.setSoundEffect(2, new int[] {0, 4}, "footstep-1", false, 1f, 0.1f, 0, 0);
		for(int i = 0; i < animSet.getAnimation(2).getFrames().length; i++) {
			animSet.getAnimation(2).getFrames()[i] = new TextureRegion(texture, 513 + 22 * i, 257, 21, 31);
		}
	}


	@Override
	public String toString() {
		return "Engineer position:" + position.toString();
	}
}
