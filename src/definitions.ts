export interface ContactPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
