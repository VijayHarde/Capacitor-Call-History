import { WebPlugin } from '@capacitor/core';
import type { ContactPlugin } from './definitions';
export declare class ContactWeb extends WebPlugin implements ContactPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    getCallLogs(): Promise<string>;
    requestPermission(): Promise<string>;
}
