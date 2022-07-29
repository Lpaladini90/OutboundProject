using Microsoft.AspNetCore.Mvc;

namespace Starterkit.Controllers;

public class SystemController : Controller
{

    public IActionResult notFound()
    {
        return View("~/Views/Pages/System/NotFound.cshtml");
    }

    public IActionResult error()
    {
        return View("~/Views/Pages/System/Error.cshtml");
    }
}
