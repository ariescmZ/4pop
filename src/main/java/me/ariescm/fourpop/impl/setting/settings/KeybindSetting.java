package me.ariescm.fourpop.impl.setting.settings;

import me.ariescm.fourpop.impl.setting.Setting;

public class KeybindSetting extends Setting {
	public int code;
	
	public KeybindSetting(int code) {
		this.name = "Key Bind";
		this.code = code;
	}
	
	public int getkeyCode() {
		return this.code;
	}
	
	public void setKeyCode(int code) {
		this.code = code;
	}

}
