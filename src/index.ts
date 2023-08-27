import { registerPlugin } from '@capacitor/core';

import type { ContactPlugin } from './definitions';

const Contact = registerPlugin<ContactPlugin>('Contact', {
  web: () => import('./web').then(m => new m.ContactWeb()),
});

export * from './definitions';
export { Contact };
