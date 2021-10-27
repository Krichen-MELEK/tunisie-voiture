import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';

import {PagesComponent} from './pages/pages.component';
import {NotFoundComponent} from './pages/not-found/not-found.component';
import {LoginComponent} from "./auth/login/login.component";

export const routes: Routes = [
    {
        path: '',
        component: PagesComponent, children: [
            {path: '', redirectTo: 'home', pathMatch: 'full' },
            {
                path: 'home',
                loadChildren: () => import('./pages/products/products.module').then(m => m.ProductsModule),
                data: {breadcrumb: 'All Products'}
            },
            // { path: '', loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule) },
            { path: 'account', loadChildren: () => import('./pages/account/account.module').then(m => m.AccountModule), data: { breadcrumb: 'Account Settings' } },
            { path: 'compare', loadChildren: () => import('./pages/compare/compare.module').then(m => m.CompareModule), data: { breadcrumb: 'Compare' } },
            { path: 'wishlist', loadChildren: () => import('./pages/wishlist/wishlist.module').then(m => m.WishlistModule), data: { breadcrumb: 'Wishlist' } },
            { path: 'cart', loadChildren: () => import('./pages/cart/cart.module').then(m => m.CartModule), data: { breadcrumb: 'Cart' } },
            { path: 'checkout', loadChildren: () => import('./pages/checkout/checkout.module').then(m => m.CheckoutModule), data: { breadcrumb: 'Checkout' } },
            { path: 'contact', loadChildren: () => import('./pages/contact/contact.module').then(m => m.ContactModule), data: { breadcrumb: 'Contact' } },
            { path: 'sign-in', loadChildren: () => import('./pages/sign-in/sign-in.module').then(m => m.SignInModule), data: { breadcrumb: 'Sign In ' } },
            { path: 'brands', loadChildren: () => import('./pages/brands/brands.module').then(m => m.BrandsModule), data: { breadcrumb: 'Brands' } },
            { path: 'products', loadChildren: () => import('./pages/products/products.module').then(m => m.ProductsModule), data: { breadcrumb: 'All Products' } }
        ]
    },
    { path: 'login', component: LoginComponent },
    { path: 'admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
    { path: '**', component: NotFoundComponent }
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, {
            preloadingStrategy: PreloadAllModules, // <- comment this line for activate lazy load
            relativeLinkResolution: 'legacy',
            initialNavigation: 'enabled'  // for one load page, without reload
            // useHash: true
        })
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule { }