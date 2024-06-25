import simpleRestProvider from 'ra-data-simple-rest'
import {
	Admin,
	defaultTheme,
	EditGuesser,
	fetchUtils,
	Resource,
	ShowGuesser,
} from 'react-admin'

import indigo from '@mui/material/colors/indigo'
import pink from '@mui/material/colors/pink'
import red from '@mui/material/colors/red'
import {CategoryCreate} from '../components/create/categoryCreate'
import {MovieCreate} from '../components/create/movieCreate'
import {RentalCreate} from '../components/create/rentalCreate'
import {UserCreate} from '../components/create/userCreate'
import {MovieEdit} from '../components/edit/movieEdit'
import {RentalEdit} from '../components/edit/rentalEdit'
import {MovieList} from '../components/lists/movieList'
import {CategoriesList} from '../components/lists/movieList copy'
import {RentalsList} from '../components/lists/rentalsList'
import {UsersList} from '../components/lists/usersList'

const myTheme = {
	...defaultTheme,
	palette: {
		mode: 'dark',
		primary: indigo,
		secondary: pink,
		error: red,
	},
	typography: {
		// Use the system font instead of the default Roboto font.
		fontFamily: [
			'-apple-system',
			'BlinkMacSystemFont',
			'"Segoe UI"',
			'Arial',
			'sans-serif',
		].join(','),
	},
	components: {
		...defaultTheme.components,
		MuiTextField: {
			defaultProps: {
				variant: 'outlined' as const,
			},
		},
		MuiFormControl: {
			defaultProps: {
				variant: 'outlined' as const,
			},
		},
	},
}

const dataProvider = simpleRestProvider(
	import.meta.env.VITE_API_URL,
	fetchUtils.fetchJson,
	'X-Total-Count'
)

const App = () => (
	<Admin dataProvider={dataProvider} theme={myTheme}>
		<Resource
			name='movies'
			list={MovieList}
			show={ShowGuesser}
			edit={MovieEdit}
			create={MovieCreate}
		/>
		<Resource
			name='users'
			list={UsersList}
			show={ShowGuesser}
			edit={EditGuesser}
			create={UserCreate}
		/>
		<Resource
			name='rentals'
			list={RentalsList}
			show={ShowGuesser}
			edit={RentalEdit}
			create={RentalCreate}
		/>
		<Resource
			name='categories'
			list={CategoriesList}
			show={ShowGuesser}
			edit={EditGuesser}
			create={CategoryCreate}
		/>
	</Admin>
)

export default App
