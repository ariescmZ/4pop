package me.ariescm.fourpop.impl.setting.settings;

import java.util.List;

import me.ariescm.fourpop.impl.Main;
import me.ariescm.fourpop.impl.module.Module;
import me.ariescm.fourpop.impl.setting.Setting;
import scala.actors.threadpool.Arrays;

public class ModeSetting extends Setting {
	public int index;
	  
	  public List<String> modes;
	  
	  public ModeSetting(String name, Module parent, String defaultMode, String... modes) {
	    this.name = name;
	    this.parent = parent;
	    this.modes = Arrays.asList(modes);
	    this.index = this.modes.indexOf(defaultMode);
	  }
	  
	  public String getMode() {
	    return this.modes.get(this.index);
	  }
	  
	  public void setMode(String mode) {
		  this.index = this.modes.indexOf(mode);

		  if(Main.saveLoadConfig != null) {
			  Main.saveLoadConfig.save();
		  }
	  }
	  
	  public boolean is(String mode) {
	    return (this.index == this.modes.indexOf(mode));
	  }
	  
	  public void cycle() {
	    if (this.index < this.modes.size() - 1) {
	      this.index++;
	    } else {
	      this.index = 0;
	    } 
	  }

}
