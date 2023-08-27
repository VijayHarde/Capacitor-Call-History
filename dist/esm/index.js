import { registerPlugin } from '@capacitor/core';
const Contact = registerPlugin('Contact', {
    web: () => import('./web').then(m => new m.ContactWeb()),
});
export * from './definitions';
export { Contact };
//# sourceMappingURL=index.js.map