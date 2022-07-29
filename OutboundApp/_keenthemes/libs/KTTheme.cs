namespace Starterkit._keenthemes.libs;

// Core theme class
public class KTTheme: IKTTheme
{
    // Theme variables
    private bool _modeSwitchEnabled;

    private string _modeDefault = "light";

    private string _direction = "ltr";

    private readonly SortedDictionary<string, SortedDictionary<string, string>> _htmlAttributes = new SortedDictionary<string, SortedDictionary<string, string>>();

    private readonly SortedDictionary<string, string[]> _htmlClasses = new SortedDictionary<string, string[]>();

    // Keep page level assets
    private readonly List<string> _javascriptFiles = new List<string>();

    private readonly List<string> _cssFiles = new List<string>();

    private readonly List<string> _vendorFiles = new List<string>();

    // Add HTML attributes by scope
    public void addHtmlAttribute(string scope, string attributeName, string attributeValue)
    {
        SortedDictionary<string, string> attributes = null;
        if (_htmlAttributes.ContainsKey(scope))
        {
            attributes = new SortedDictionary<string, string>(_htmlAttributes[scope]);
        }
        else
        {
            attributes = new SortedDictionary<string, string>();
        }

        attributes[attributeName] = attributeValue;
        _htmlAttributes[scope] = attributes;
    }

    // Add HTML class by scope
    public void addHtmlClass(string scope, string className)
    {
        var list = new List<string>();
        if (_htmlClasses.ContainsKey(scope))
        {
            list = _htmlClasses[scope].ToList();
        }
        list.Add(className);
        _htmlClasses[scope] = list.ToArray();
    }

    // Print HTML attributes for the HTML template
    public string printHtmlAttributes(string scope)
    {
        var list = new List<string>();
        if (_htmlAttributes.ContainsKey(scope))
        {
            foreach (KeyValuePair<string, string> attribute in _htmlAttributes[scope])
            {
                var item = attribute.Key + "=" + attribute.Value;
                list.Add(item);
            }
            return String.Join(" ", list);
        }
        return null;
    }

    // Print HTML classes for the HTML template
    public string printHtmlClasses(string scope)
    {
        if (_htmlClasses.ContainsKey(scope))
        {
            return String.Join(" ", _htmlClasses[scope]);
        }
        return null;
    }

    public string getImageUrl(string path)
    {
        var url = path;

        return url;
    }

    // Get SVG icon content
    public string getSvgIcon(string path, string classNames)
    {
        var svg = System.IO.File.ReadAllText($"./wwwroot/assets/media/icons/{path}");

        return $"<span class=\"{classNames}\">{svg}</span>";
    }

    // Set dark mode enabled status
    public void setModeSwitch(bool flag)
    {
        _modeSwitchEnabled = flag;
    }

    // Check dark mode status
    public bool isModeSwitchEnabled()
    {
        return _modeSwitchEnabled;
    }

    // Set the mode to dark or light
    public void setModeDefault(string flag)
    {
        _modeDefault = flag;
    }

    // Get current mode
    public string getModeDefault()
    {
        return _modeDefault;
    }

    // Set style direction
    public void setDirection(string direction)
    {
       _direction = direction;
    }

    // Get style direction
    public string getDirection()
    {
        return _direction;
    }

    // Check if style direction is RTL
    public bool isRtlDirection()
    {
        return _direction.ToLower() == "rtl";
    }

    public string getAssetsFullPath(string path)
    {
        return $"/{KTThemeSettings.config.AssetsDir}{path}";
    }

    public string getView(string path)
    {
        return $"{KTThemeSettings.config.ThemeDir}/{path}";
    }

    // Extend CSS file name with RTL
    public string extendCssFilename(string path)
    {

        if (isRtlDirection())
        {
            path = path.Replace(".css", ".rtl.css");
        }

        return path;
    }

    // Include favicon from settings
    public string getFavicon()
    {
        return getAssetsFullPath(KTThemeSettings.config.Assets.Favicon);
    }

    // Include the fonts from settings
    public string[] getFonts()
    {
        return KTThemeSettings.config.Assets.Fonts.ToArray();
    }

    // Get the global assets
    public string[] getGlobalAssets(String type)
    {
        List<string> files =
            type == "Css" ? KTThemeSettings.config.Assets.Css : KTThemeSettings.config.Assets.Js;
        List<string> newList = new List<string>();

        foreach (string file in files)
        {
            if (type == "Css")
            {
                newList.Add(getAssetsFullPath(extendCssFilename(file)));
            }
            else
            {
                newList.Add(getAssetsFullPath(file));
            }
        }

        return newList.ToArray();
    }

    // Add multiple vendors to the page by name
    public void addVendors(string[] vendors)
    {
        foreach (var vendor in vendors)
        {
            if (!_vendorFiles.Contains(vendor))
            {
                _vendorFiles.Add(vendor);
            }
        }
    }

    // Add single vendor to the page by name
    public void addVendor(string vendor)
    {
        if (!_vendorFiles.Contains(vendor))
        {
            _vendorFiles.Add(vendor);
        }
    }

    // Add custom javascript file to the page
    public void addJavascriptFile(string file)
    {
        if (!_javascriptFiles.Contains(file))
        {
            _javascriptFiles.Add(file);
        }
    }

    // Add custom CSS file to the page
    public void addCssFile(string file)
    {
        if (!_cssFiles.Contains(file))
        {
            _cssFiles.Add(file);
        }
    }

    public string[] getJavascriptFiles()
    {
        return _javascriptFiles.ToArray();
    }

    public string[] getCssFiles()
    {
        return _cssFiles.ToArray();
    }

    // Get vendor files from settings
    public string[] getVendors(string type)
    {
        var vendors = KTThemeSettings
            .config
            .Vendors;
        var files = new List<string>();
        foreach (var vendor in _vendorFiles)
        {
            if (vendors.ContainsKey(vendor) && vendors[vendor].ContainsKey(type))
            {
                var vendorFiles = vendors[vendor][type];
                foreach (var file in vendorFiles)
                {
                    var vendorPath = file.Contains("https://") ? file : getAssetsFullPath(file);
                    files.Add(vendorPath);
                }
            }
        }
        return files.ToArray();
    }

    public string getAttributeValue(string scope, string attributeName){
        if (_htmlAttributes.ContainsKey(scope))
        {
            if (_htmlAttributes[scope].ContainsKey(attributeName))
            {
                return _htmlAttributes[scope][attributeName];
            }
            return "";
        }

        return "";
    }
}
