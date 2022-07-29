using Starterkit._keenthemes.libs;

namespace Starterkit._keenthemes;
public class KTBootstrapBase: IKTBootstrapBase {
    private IKTTheme _theme;

    // Init theme mode option from settings
    public void initThemeMode()
    {
        _theme.setModeSwitch(KTThemeSettings.config.ModeSwitchEnabled);
        _theme.setModeDefault(KTThemeSettings.config.ModeDefault);
    }
 
    // Init theme direction option (RTL or LTR) from settings
    // Init RTL html attributes by checking if RTL is enabled.
    // This function is being called for the html tag
    public void initThemeDirection()
    {
        _theme.setDirection(KTThemeSettings.config.Direction);

        if (_theme.isRtlDirection())
        {
            _theme.addHtmlAttribute("html", "direction", "rtl");
            _theme.addHtmlAttribute("html", "dir", "rtl");
            _theme.addHtmlAttribute("html", "style", "direction: rtl");
        }
    }

    public void initLayout()
    {
        _theme.addHtmlAttribute("body", "id", "kt_app_body");
    }

    // Init a global theme vendors and custom files
    public void initGlobalFiles()
    {
        
    }

    // Global theme initializer
    public void init(IKTTheme theme)
    {
        _theme = theme;
        
        initThemeMode();
        initThemeDirection();
        initLayout();
        initGlobalFiles();
    }
}
