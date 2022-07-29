namespace Starterkit._keenthemes.libs;

// Core theme interface
public interface IKTTheme
{
    void addHtmlAttribute(string scope, string attributeName, string attributeValue);
    void addHtmlClass(string scope, string className);

    string printHtmlAttributes(string scope);

    string printHtmlClasses(string scope);

    string getImageUrl(string path);

    string getSvgIcon(string path, string cls);

    void setModeSwitch(bool flag);
    bool isModeSwitchEnabled();
    
    void setModeDefault(string flag);

    string getModeDefault();

    void setDirection(string direction);

    string getDirection();

    bool isRtlDirection();

    string getAssetsFullPath(string path);

    string getView(string path);

    string extendCssFilename(string path);

    string getFavicon();

    string[] getFonts();

    string[] getGlobalAssets(String type);

    void addVendors(string[] vendors);

    void addVendor(string vendor);

    void addJavascriptFile(string file);

    void addCssFile(string file);

    string[] getJavascriptFiles();

    string[] getCssFiles();

    string[] getVendors(string type);

    string getAttributeValue(string scope, string attributeName);
}
