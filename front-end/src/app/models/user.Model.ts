import { Timestamp } from "rxjs";

enum roles {
    'user',
    'admin',
    'db_admin'
}

export interface User {
    id: number;
    firstName: string;
    lastName: string;
    userName: string;
    email: string;
    password: string;
    dateOfBirth: Date;
    role: roles;
    createdAt: Timestamp<string>;
    updateAt: Timestamp<string>;
    active: Boolean
}