# capacitor-contact

Capacitor plugin to access contact and contact information.

## Install

```bash
npm install capacitor-contact
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`getCallLogs()`](#getcalllogs)
* [`requestPermission()`](#requestpermission)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### getCallLogs()

```typescript
getCallLogs() => Promise<string>
```

**Returns:** <code>Promise&lt;string&gt;</code>

--------------------


### requestPermission()

```typescript
requestPermission() => Promise<string>
```

**Returns:** <code>Promise&lt;string&gt;</code>

--------------------

</docgen-api>
