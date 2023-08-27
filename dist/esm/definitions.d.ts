export interface ContactPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    getCallLogs(): Promise<string>;
    requestPermission(): Promise<string>;
}
