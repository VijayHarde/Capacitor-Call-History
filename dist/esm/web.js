import { WebPlugin } from '@capacitor/core';
export class ContactWeb extends WebPlugin {
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
//# sourceMappingURL=web.js.map