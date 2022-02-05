package me.ariescm.fourpop.impl.setting.settings;

import me.ariescm.fourpop.impl.Main;
import me.ariescm.fourpop.impl.module.Module;
import me.ariescm.fourpop.impl.setting.Setting;

public class BooleanSetting extends Setting {
	public boolean enabled;
	
	public BooleanSetting(String name, Module parent, boolean enabled) {
		this.name = name;
		this.parent = parent;
		this.enabled = enabled;
	}
	
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;

		if(Main.saveLoadConfig != null) {
			Main.saveLoadConfig.save();
		}
	}
	
	public void toggled() {
		this.enabled = !this.enabled;

		if(Main.saveLoadConfig != null) {
			Main.saveLoadConfig.save();
		}
	}

}
