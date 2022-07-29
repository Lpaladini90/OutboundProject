using Microsoft.AspNetCore.Mvc;

namespace Starterkit.Controllers;

public class AuthController : Controller
{
    public IActionResult signIn()
    {
        return View("~/Views/Pages/Auth/SignIn.cshtml");
    }

    public IActionResult signUp()
    {
        return View("~/Views/Pages/Auth/SignUp.cshtml");
    }

    public IActionResult resetPassword()
    {
        return View("~/Views/Pages/Auth/ResetPassword.cshtml");
    }

    public IActionResult newPassword()
    {
        return View("~/Views/Pages/Auth/NewPassword.cshtml");
    }    
}
