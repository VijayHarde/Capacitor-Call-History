var capacitorContact = (function (exports, core) {
    'use strict';

    const Contact = core.registerPlugin('Contact', {
        web: () => Promise.resolve().then(function () { return web; }).then(m => new m.ContactWeb()),
    });

    class ContactWeb extends core.WebPlugin {
        async echo(options) {
            console.log('ECHO', options);
            return options;
        }
        async getCallLogs() {
            return "This method is not supported for the web platform";
        }
        async requestPermission() {
            return "This methos is not supported for the web plastform";
        }
    }

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        ContactWeb: ContactWeb
    });

    exports.Contact = Contact;

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
