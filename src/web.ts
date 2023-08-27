import { WebPlugin } from '@capacitor/core';

import type { ContactPlugin } from './definitions';

export class ContactWeb extends WebPlugin implements ContactPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
