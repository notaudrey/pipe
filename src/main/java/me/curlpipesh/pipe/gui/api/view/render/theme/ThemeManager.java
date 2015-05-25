package me.curlpipesh.pipe.gui.api.view.render.theme;

import me.curlpipesh.pipe.gui.api.test.TestTheme;
import lombok.Getter;
import lombok.Setter;

public final class ThemeManager {
    @Getter
    @Setter
    private static ITheme theme = new TestTheme();
}
