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
/*!*******************************************************!*\
  !*** ./webpack/plugins/custom/draggable/draggable.js ***!
  \*******************************************************/
__webpack_require__.r(__webpack_exports__);
// Draggable - a lightweight, responsive, modern drag & drop library: https://shopify.github.io/draggable/

require('@shopify/draggable/lib/draggable.bundle.js');
require('@shopify/draggable/lib/draggable.bundle.legacy.js');
require('@shopify/draggable/lib/draggable.js');
window.Sortable = require('@shopify/draggable/lib/sortable.js');
window.Droppable = require('@shopify/draggable/lib/droppable.js');
window.Swappable = require('@shopify/draggable/lib/swappable.js');
require('@shopify/draggable/lib/plugins.js');
require('@shopify/draggable/lib/plugins/collidable.js');
require('@shopify/draggable/lib/plugins/resize-mirror.js');
require('@shopify/draggable/lib/plugins/snappable.js');
require('@shopify/draggable/lib/plugins/swap-animation.js');

/******/ })()
;
//# sourceMappingURL=draggable.bundle.js.map