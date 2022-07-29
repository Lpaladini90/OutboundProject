/******/ (() => { // webpackBootstrap
/******/ 	"use strict";
/******/ 	// The require scope
/******/ 	var __webpack_require__ = {};
/******/ 	
/************************************************************************/
/******/ 	/* webpack/runtime/make namespace object */
/******/ 	(() => {
/******/ 		// define __esModule on exports
/******/ 		__webpack_require__.r = (exports) => {
/******/ 			if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 				Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 			}
/******/ 			Object.defineProperty(exports, '__esModule', { value: true });
/******/ 		};
/******/ 	})();
/******/ 	
/************************************************************************/
var __webpack_exports__ = {};
/*!***************************************************!*\
  !*** ./webpack/plugins/custom/prismjs/prismjs.js ***!
  \***************************************************/
__webpack_require__.r(__webpack_exports__);
// Prism - is a lightweight, extensible syntax highlighter, built with modern web standards in mind: https://prismjs.com/

window.Prism = require("prismjs/prism.js");
require("prismjs/components/prism-markup.js");
require("prismjs/components/prism-markup-templating.js");
require("prismjs/components/prism-bash.js");
require("prismjs/components/prism-javascript.js");
require("prismjs/components/prism-scss.js");
require("prismjs/components/prism-css.js");
require("prismjs/components/prism-php.js");
require("prismjs/components/prism-php-extras.js");
require("prismjs/plugins/normalize-whitespace/prism-normalize-whitespace.js");
require("@/js/vendors/plugins/prism.init.js");

require('./prismjs.scss');

/******/ })()
;
//# sourceMappingURL=prismjs.bundle.js.map