import { WebPlugin } from '@capacitor/core';

import type { ContactPlugin } from './definitions';

export class ContactWeb extends WebPlugin implements ContactPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async getCallLogs(): Promise<string> {
    return "This method is not supported for the web platform";
  }

  async requestPermission(): Promise<string> {
    return "This methos is not supported for the web plastform";
  }
}
