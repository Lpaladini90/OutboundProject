using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using Starterkit._keenthemes.libs;
using Starterkit.Models;
using Microsoft.AspNetCore.Localization;

namespace Starterkit.Controllers;

public class DashboardsController : Controller
{
    private readonly ILogger<DashboardsController> _logger;

    public DashboardsController(ILogger<DashboardsController> logger)
    {
        _logger = logger;
    }

    public IActionResult index()
    {
        return View("~/Views/Pages/Dashboards/Index.cshtml");
    }
}
