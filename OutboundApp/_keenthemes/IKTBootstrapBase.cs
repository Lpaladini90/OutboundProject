using Starterkit._keenthemes.libs;

namespace Starterkit._keenthemes;

public interface IKTBootstrapBase
{
    void initThemeMode();
    
    void initThemeDirection();

    void initLayout();
    
    void init(IKTTheme theme);
}